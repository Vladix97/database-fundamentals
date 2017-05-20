package dao_pattern.constants;

/**
 * Created by vladix on 5/20/17.
 */
public class Constants {

    public static final String SERVER_URL = "jdbc:mysql://localhost:3306?useSSL=false";

    public static final String DB_URL = "jdbc:mysql://localhost:3306/%s?useSSL=false";

    public static final String USER = "root";

    public static final String PASSWORD = "1234";

    public static final String CREATE_DATABASE = "CREATE DATABASE IF NOT EXISTS %s";

    public static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS %s(" +
                                                "id INT PRIMARY KEY AUTO_INCREMENT," +
                                                "name VARCHAR(50))";

    public static final String SQL_SELECT_STUDENTS = "SELECT * FROM students";

    public static final String SQL_INSERT_STUDENTS = "INSERT INTO students(id, name) " +
                                                        "VALUES(?, ?)";

    public static final String SQL_UPDATE_STUDENTS = "UPDATE students " +
                                                        "SET name = ? " +
                                                       "WHERE id = ?";

    public static final String SQL_DELETE_STUDENTS = "DELETE FROM students " +
                                                        "WHERE id = ?";
}
