package app.service;

import app.entities.Student;

import java.util.List;

/**
 * Created by vladix on 5/26/17.
 */

public interface StudentService {

    void register(Student student);

    void expel(Student student);

    Student find(long id);

    List<Student> findByFirstName(List<String> firstNames);

    List<Student> findByFirstName(String firstName);
}
