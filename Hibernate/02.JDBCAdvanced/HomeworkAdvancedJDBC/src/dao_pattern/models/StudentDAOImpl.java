package dao_pattern.models;

import dao_pattern.connections.DatabaseConnection;
import dao_pattern.constants.Constants;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by vladix on 5/20/17.
 */
public class StudentDAOImpl implements StudentDAO {

    private String databaseName;

    private Connection connection;

    private PreparedStatement preparedStatement;

    private ResultSet resultSet;

    public StudentDAOImpl(String databaseName) {
        this.databaseName = databaseName;
    }

    @Override
    public List<Student> getAllStudents() throws SQLException {
        List<Student> studentsToReturn = new ArrayList<>();

        this.connection = DatabaseConnection.getConnection(this.databaseName);
        this.preparedStatement = this.connection.prepareStatement(Constants.SQL_SELECT_STUDENTS);
        this.resultSet = this.preparedStatement.executeQuery();

        while (resultSet.next()) {
            int id = this.resultSet.getInt("id");
            String name = this.resultSet.getString("name");

            Student student = new Student(id, name);
            studentsToReturn.add(student);
        }

        return Collections.unmodifiableList(studentsToReturn);
    }

    @Override
    public void addStudent(Student student) throws SQLException {
        this.connection = DatabaseConnection.getConnection(this.databaseName);
        this.preparedStatement = this.connection.prepareStatement(Constants.SQL_INSERT_STUDENTS);

        int id = student.getId();
        String name = student.getName();
        this.preparedStatement.setInt(1, id);
        this.preparedStatement.setString(2, name);

        this.preparedStatement.execute();
    }

    @Override
    public int updateStudent(Student student) throws SQLException {
        this.connection = DatabaseConnection.getConnection(this.databaseName);
        this.preparedStatement = this.connection.prepareStatement(Constants.SQL_UPDATE_STUDENTS);

        int id = student.getId();
        String name = student.getName();
        this.preparedStatement.setString(1 , name);
        this.preparedStatement.setInt(2, id);

        return this.preparedStatement.executeUpdate();
    }

    @Override
    public int deleteStudent(Student student) throws SQLException {
        this.connection = DatabaseConnection.getConnection(this.databaseName);
        this.preparedStatement = this.connection.prepareStatement(Constants.SQL_DELETE_STUDENTS);

        int id = student.getId();
        this.preparedStatement.setInt(1, id);

        return this.preparedStatement.executeUpdate();
    }


    @Override
    public void close() throws Exception {
        if (this.resultSet != null) {
            this.resultSet.close();;
        }

        if (this.preparedStatement != null) {
            this.preparedStatement.close();
        }

        if (this.connection != null) {
            this.connection.close();
        }
    }

}
