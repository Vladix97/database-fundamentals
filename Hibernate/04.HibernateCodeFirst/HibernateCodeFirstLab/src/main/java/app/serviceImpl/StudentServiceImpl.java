package app.serviceImpl;

import app.dao.StudentDao;
import app.entities.Student;
import app.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by vladix on 5/26/17.
 */

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDao studentDao;

    @Override
    public void register(Student student) {
        this.studentDao.saveAndFlush(student);
    }

    @Override
    public void expel(Student student) {
        this.studentDao.delete(student);
    }

    @Override
    public Student find(long id) {
        return this.studentDao.findOne(id);
    }

    @Override
    public List<Student> findByFirstName(String firstName) {
        return this.studentDao.findByFirstName(firstName);
    }

    @Override
    public List<Student> findByFirstName(List<String> firstNames) {
        return this.studentDao.findByFirstNameIn(firstNames);
    }

}
