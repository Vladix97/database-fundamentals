package app.connections;

import app.constants.Constants;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by vladix on 5/22/17.
 */
public class ServerConnection {

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(Constants.SERVER_URL, Constants.USER, Constants.PASSWORD);
    }

}
