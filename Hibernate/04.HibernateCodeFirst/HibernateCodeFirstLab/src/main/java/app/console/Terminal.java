package app.console;

import app.entities.Major;
import app.entities.Student;
import app.service.MajorService;
import app.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

/**
 * Created by vladix on 5/26/17.
 */

@Component
public class Terminal implements CommandLineRunner {

    @Autowired
    private MajorService majorService;

    @Autowired
    private StudentService studentService;

    @Override
    public void run(String... strings) throws Exception {

        Major major = new Major("IT");

        Student student = new Student("Goshko", "Peshko", new Date(), major);

        this.majorService.create(major);
        this.studentService.register(student);


        this.studentService.expel(student);

//        this.majorService.deleteByName("IT");

//        List<Student> studentNames = this.studentService.findByFirstName("Goshko");
//        for (Student studentName : studentNames) {
//            System.out.println(student.getFirstName());
//        }
        
    }
}
