package app.orm;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

/**
 * Created by vladix on 5/22/17.
 */
public interface Manager {

    <E> void persist(String databaseName, E entity) throws IllegalAccessException, SQLException; // it will insert or update entity depending if it is attached to the context

    <E> Iterable<E> find(String databaseName, Class<E> table) throws SQLException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException; // returns collection of all entity objects of type E

    <E> Iterable<E> find(String databaseName, Class<E> table, String where) throws InvocationTargetException, SQLException, InstantiationException, IllegalAccessException, NoSuchMethodException; // returns collection of all entity objects of type T matching the criteria given in “where”

    <E> E findFirst(String databaseName, Class<E> table) throws InvocationTargetException, SQLException, InstantiationException, IllegalAccessException, NoSuchMethodException; // returns the first entity object of type E

    <E> E findFirst(String databaseName, Class<E> table, String where) throws SQLException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException; // returns the first entity object of type E matching the criteria given in “where”

}
