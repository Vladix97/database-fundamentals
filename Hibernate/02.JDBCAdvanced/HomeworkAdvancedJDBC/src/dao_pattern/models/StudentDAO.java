package dao_pattern.models;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by vladix on 5/20/17.
 */
public interface StudentDAO extends AutoCloseable {

    List<Student> getAllStudents() throws SQLException;

    void addStudent(Student student) throws SQLException;

    int updateStudent(Student student) throws SQLException;

    int deleteStudent(Student student) throws SQLException;


}
