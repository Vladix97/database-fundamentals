package app.connections;

import app.constants.Constants;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by vladix on 5/22/17.
 */
public class DatabaseConnection {

    public static Connection getConnection(String databaseName) throws SQLException {
        createDBIfNotExists(databaseName);

        return DriverManager.getConnection(
                String.format(Constants.DATABASE_URL, databaseName), Constants.USER, Constants.PASSWORD);
    }

    private static void createDBIfNotExists(String databaseName) throws SQLException {
        Connection connection = ServerConnection.getConnection();
        Statement statement = connection.createStatement();
        statement.execute(String.format(Constants.SQL_CREATE_DATABASE_IF_NOT_EXISTS, databaseName));
    }

}
