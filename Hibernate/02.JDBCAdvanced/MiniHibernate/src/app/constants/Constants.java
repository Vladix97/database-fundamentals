package app.constants;

/**
 * Created by vladix on 5/22/17.
 */
public class Constants {

    public static final String SERVER_URL = "jdbc:mysql://localhost:3306?useSSL=false";

    public static final String DATABASE_URL = "jdbc:mysql://localhost:3306/%s?useSSL=false";

    public static final String USER = "root";

    public static final String PASSWORD = "1234";

    public static final String SQL_CREATE_DATABASE_IF_NOT_EXISTS = "CREATE DATABASE IF NOT EXISTS %s";

    public static final String SQL_SELECT_FROM_DATABASE = "SELECT * FROM %s";

}
