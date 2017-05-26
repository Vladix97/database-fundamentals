package app.entities;

import javax.persistence.*;
import java.util.List;

/**
 * Created by vladix on 5/26/17.
 */

@Entity
@Table(name = "majors")
public class Major {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "major_id")
    private long majorId;

    @Basic
    private String name;

    @OneToMany(mappedBy = "major")
    private List<Student> students;

    public Major() {
        super();
    }

    public Major(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Student> getStudents() {
        return this.students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
