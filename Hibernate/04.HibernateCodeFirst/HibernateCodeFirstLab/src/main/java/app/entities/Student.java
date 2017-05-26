package app.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by vladix on 5/26/17.
 */

@Entity
@Table(name = "students")
public class Student implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private long studentId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "registration_date")
    private Date registrationDate;

    @ManyToOne
    @JoinColumn(name = "major_id")
    private Major major;

    public Student() {
        super();
    }

    public Student(String firstName, String lastName, Date registrationDate, Major major) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.registrationDate = registrationDate;
        this.major = major;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getRegistrationDate() {
        return this.registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public Major getMajor() {
        return this.major;
    }

    public void setMajor(Major major) {
        this.major = major;
    }
}
