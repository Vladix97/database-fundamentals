import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class p01_initialSetup {

    private static final String URL = "jdbc:mysql://localhost:3306?useSSL=false";

    private static final String USER = "root";

    private static final String PASSWORD = "1234";

    public static void main(String[] args) {


        try (
                Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
                Statement statement = connection.createStatement();
                ) {

            String query = "CREATE DATABASE minions_db;";
            statement.execute(query);

            query = "USE minions_db;";
            statement.execute(query);

            query = "CREATE TABLE minions(" +
                    "minion_id INT PRIMARY KEY AUTO_INCREMENT," +
                    "name VARCHAR(50)," +
                    "age INT," +
                    "town_id INT" +
                    ");";
            statement.execute(query);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
