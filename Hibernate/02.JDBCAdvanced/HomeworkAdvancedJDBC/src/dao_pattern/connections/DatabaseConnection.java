package dao_pattern.connections;

import dao_pattern.constants.Constants;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by vladix on 5/20/17.
 */
public class DatabaseConnection {

    public static Connection getConnection(String databaseName) throws SQLException {
        return DriverManager.getConnection(String.format(Constants.DB_URL, databaseName), Constants.USER, Constants.PASSWORD);
    }

}
