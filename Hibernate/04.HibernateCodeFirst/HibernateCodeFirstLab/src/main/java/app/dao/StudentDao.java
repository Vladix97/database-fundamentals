package app.dao;

import app.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by vladix on 5/26/17.
 */

@Repository
@Transactional
public interface StudentDao extends JpaRepository<Student, Long> {

    List<Student> findByFirstNameIn(List<String> studentNames);

    List<Student> findByFirstName(String studentName);
}
