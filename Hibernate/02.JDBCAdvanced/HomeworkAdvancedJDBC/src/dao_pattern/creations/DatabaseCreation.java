package dao_pattern.creations;

import dao_pattern.constants.Constants;
import dao_pattern.connections.ServerConnection;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by vladix on 5/20/17.
 */
public class DatabaseCreation {

    public static void createDatabase(String databaseName) {

        try (Connection connection = ServerConnection.getConnection();
             Statement statement = connection.createStatement();
        ) {
            statement.execute(String.format(Constants.CREATE_DATABASE, databaseName));
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
