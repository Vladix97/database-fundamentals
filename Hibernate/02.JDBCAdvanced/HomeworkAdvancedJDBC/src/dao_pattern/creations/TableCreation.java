package dao_pattern.creations;

import dao_pattern.constants.Constants;
import dao_pattern.connections.DatabaseConnection;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by vladix on 5/20/17.
 */
public class TableCreation {

    public static void createTable(String databaseName, String tableName) {

        try (Connection connection = DatabaseConnection.getConnection(databaseName);
             Statement statement = connection.createStatement();
         ) {
            statement.execute(String.format(Constants.CREATE_TABLE, tableName));
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
