package app.orm;

import app.annotations.Column;
import app.annotations.Entity;
import app.annotations.Id;
import app.connections.DatabaseConnection;
import app.constants.Constants;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by vladix on 5/22/17.
 */
public class EntityManager implements Manager {

    @Override
    public <E> void persist(String databaseName, E entity) throws IllegalAccessException, SQLException {
        Connection connection = DatabaseConnection.getConnection(databaseName);

        Class<?> entityClass = entity.getClass();
        Field[] declaredFields = entityClass.getDeclaredFields();

        String tableName = this.getTableName(entityClass);
        this.createTableIfNotExists(connection, entityClass, tableName);

        String idColumnName = this.getIdName(entity, declaredFields);
        int id = this.getId(entity, declaredFields);
        this.checkForSameId(connection, tableName, idColumnName, id);

        this.insertInto(connection, tableName, entity);

        connection.close();
    }

    @Override
    public <E> Iterable<E> find(String databaseName, Class<E> table) throws SQLException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Connection connection = DatabaseConnection.getConnection(databaseName);
        String tableName = null;
        if (table.isAnnotationPresent(Entity.class)) {
            tableName = table.getDeclaredAnnotation(Entity.class).tableName();
        }

        if (tableName == null) {
            throw new IllegalArgumentException("Class is not an entity");
        }

        List<E> entities = new ArrayList<>();
        Constructor<E> constructor = table.getConstructor(int.class, String.class, String.class, Integer.class, Date.class);

        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(String.format(Constants.SQL_SELECT_FROM_DATABASE, tableName))
        ) {

            while (resultSet.next()) {
                int id = resultSet.getInt("user_id");
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                Integer age = resultSet.getInt("age");
                Date date = resultSet.getDate("registration_date");

                E entity = constructor.newInstance(id, username, password, age, date);
                entities.add(entity);
            }
        }

        connection.close();
        return entities;
    }

    @Override
    public <E> Iterable<E> find(String databaseName, Class<E> table, String where) throws InvocationTargetException, SQLException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        List<E> filtered = new ArrayList<>();

        Iterable<E> entities = this.find(databaseName, table);
        Map<String, String> valueByFieldName = getValueByFieldName(where);

        for (E entity : entities) {
            Field[] declaredFields = table.getDeclaredFields();
            for (Field declaredField : declaredFields) {
                declaredField.setAccessible(true);

                String fieldName = declaredField.getName();
                Object fieldValue = declaredField.get(entity);

                if (fieldValue != null &&
                        valueByFieldName.containsKey(fieldName) &&
                        valueByFieldName.get(fieldName).equals(fieldValue.toString())) {
                    filtered.add(entity);
                }
            }
        }

        return filtered;
    }

    @Override
    public <E> E findFirst(String databaseName, Class<E> table) throws InvocationTargetException, SQLException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        Iterable<E> entities = this.find(databaseName, table);
        try {
            return entities.iterator().next();
        } catch (NoSuchElementException e) {
            return null;
        }
    }

    @Override
    public <E> E findFirst(String databaseName, Class<E> table, String where) throws SQLException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        Iterable<E> entities = this.find(databaseName, table, where);
        try {
            return entities.iterator().next();
        } catch (NoSuchElementException e) {
            return null;
        }
    }

    private Map<String, String> getValueByFieldName(String where) {
        String[] whereArguments = where.split("=|\\s+AND\\s+");
        Map<String, String> valueByFieldName = new HashMap<>();
        for (int i = 0; i < whereArguments.length; i += 2) {
            String fieldName = whereArguments[i];
            String value = whereArguments[i + 1];
            if (value.startsWith("'")) {
                value = value.substring(1, value.length() - 1);
            }

            valueByFieldName.put(fieldName, value);
        }

        return valueByFieldName;
    }


    private String getTableName(Class<?> entityClass) {
        String tableName = null;

        if (entityClass.isAnnotationPresent(Entity.class)) {
            Entity declaredAnnotation = entityClass.getDeclaredAnnotation(Entity.class);
            tableName = declaredAnnotation.tableName();
        }

        if (tableName == null) {
            throw new IllegalArgumentException("Table name is not specified!");
        }

        return tableName;
    }

    private <E> int getId(E entity, Field[] declaredFields) throws IllegalAccessException {
        int id = -1;

        for (Field declaredField : declaredFields) {
            declaredField.setAccessible(true);

            if (declaredField.isAnnotationPresent(Id.class)) {
                id = (int) declaredField.get(entity);
                break;
            }
        }

        if (id == -1) {
            throw new IllegalArgumentException("Class has no primary key column!");
        }

        return id;
    }

    private void checkForSameId(Connection connection, String tableName, String idColumnName, int id) throws SQLException {
        int rowCount = -1;
        String query = "SELECT COUNT(*) FROM " + tableName + " WHERE " + idColumnName + "=" + id;

        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)
        ) {
            resultSet.next();
            rowCount = resultSet.getInt(1);
        }

        if (rowCount > 0) {
            throw new IllegalArgumentException("Entity with same id already exists!");
        }
    }

    private <E> void insertInto(Connection connection, String tableName, E entity) throws IllegalAccessException {
        StringBuilder query = new StringBuilder();
        query.append("INSERT INTO ").append(tableName).append("(");
        String columnsForInsert = this.getTableColumnsForInsert(entity) + ") VALUES(";
        String entityValues = this.getEntityValues(entity) + ")";

        query.append(columnsForInsert).append(entityValues);

        try (Statement statement = connection.createStatement()) {
            statement.execute(query.toString());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private <E> String getEntityValues(E entity) throws IllegalAccessException {
        StringBuilder values = new StringBuilder();
        Field[] declaredFields = entity.getClass().getDeclaredFields();
        for (Field declaredField : declaredFields) {
            declaredField.setAccessible(true);

            if (declaredField.isAnnotationPresent(Column.class)) {
                if (declaredField.get(entity) != null) {
                    if (declaredField.getType().getSimpleName().equals("Date")) {
                        values.append("'" + new SimpleDateFormat("yyyy-MM-d").format(declaredField.get(entity)) + "'");
                    } else {
                        values.append("'" + declaredField.get(entity) + "'");
                    }
                } else {
                    values.append(declaredField.get(entity));
                }

                values.append(",");
            }
        }

        values.deleteCharAt(values.length() - 1);
        return values.toString();
    }

    private <E> String getTableColumnsForInsert(E entity) {
        StringBuilder tableColumns = new StringBuilder();

        Field[] declaredFields = entity.getClass().getDeclaredFields();
        for (Field field : declaredFields) {
            field.setAccessible(true);

            if (field.isAnnotationPresent(Column.class)) {
                Column column = field.getAnnotation(Column.class);
                tableColumns.append(column.columnName());
                tableColumns.append(",");
            }
        }

        tableColumns.deleteCharAt(tableColumns.length() - 1);
        return tableColumns.toString();
    }

    private <E> String getIdName(E entity, Field[] declaredFields) {
        for (Field declaredField : declaredFields) {
            if (declaredField.isAnnotationPresent(Id.class) && declaredField.isAnnotationPresent(Column.class)) {
                Column column = declaredField.getAnnotation(Column.class);
                return column.columnName();
            }
        }

        throw new IllegalArgumentException("Entity has no primary key column!");
    }

    private void createTableIfNotExists(Connection connection, Class<?> entityClass, String tableName) {
        String createTable = "CREATE TABLE IF NOT EXISTS " + tableName + " (";
        String columns = this.getTableColumnsForCreate(entityClass) + ")";

        try (Statement statement = connection.createStatement()) {
            statement.execute(createTable + columns);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private String getTableColumnsForCreate(Class<?> entityClass) {
        StringBuilder columns = new StringBuilder();

        Field[] declaredFields = entityClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            if (declaredField.isAnnotationPresent(Column.class)) {
                String columnName = declaredField.getAnnotation(Column.class).columnName();
                String fieldName = declaredField.getType().getSimpleName();

                // mapping java data types with mysql
                switch (fieldName) {
                    case "int":
                    case "Integer":
                        columns.append(columnName).append(" ").append("INT");
                        break;
                    case "double":
                    case "Double":
                        columns.append(columnName).append(" ").append("DECIMAL");
                        break;
                    case "String":
                        columns.append(columnName).append(" ").append("VARCHAR(50)");
                        break;
                    case "Date":
                        columns.append(columnName).append(" ").append("DATE");
                        break;
                }

                if (declaredField.isAnnotationPresent(Id.class)) {
                    columns.append(" PRIMARY KEY");
                }

                columns.append(",");
            }
        }


        if (columns.length() == 0) {
            throw new IllegalArgumentException("The class has no columns");
        }

        return columns.deleteCharAt(columns.length() - 1).toString();    // removes last `,`
    }

}
