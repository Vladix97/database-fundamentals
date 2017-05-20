package dao_pattern;

import dao_pattern.creations.DatabaseCreation;
import dao_pattern.creations.TableCreation;
import dao_pattern.models.Student;
import dao_pattern.models.StudentDAO;
import dao_pattern.models.StudentDAOImpl;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by vladix on 5/20/17.
 */
public class Main {

    public static void main(String[] args) throws SQLException {

        DatabaseCreation.createDatabase("schools");

        TableCreation.createTable("schools", "students");

        StudentDAO studentDAO = new StudentDAOImpl("schools");

        Student student;
        List<Student> allStudents;
        
        // adding students
//        Student student = new Student();
//        student.setName("GOSHO");
//        studentDAO.addStudent(student);


        // gettings all students
//        List<Student> allStudents = studentDAO.getAllStudents();
//        System.out.println(allStudents);


        // updating / altering students
//        Student updated = new Student(123, "PESHO");
//        System.out.println(studentDAO.updateStudent(updated));


//        Student student = new Student(1, "someName");
//        System.out.println(studentDAO.deleteStudent(student));

    }
}
