package app.entities;

import app.annotations.Column;
import app.annotations.Entity;
import app.annotations.Id;

import java.util.Date;

/**
 * Created by vladix on 5/22/17.
 */
@Entity(tableName = "users")
public class User {

    @Id
    @Column(columnName = "user_id")
    private int id;

    @Column(columnName = "username")
    private String username;

    @Column(columnName = "password")
    private String password;

    @Column(columnName = "age")
    private Integer age;

    @Column(columnName = "registration_date")
    private Date registrationDate;

    // ============================================================================
    // ============================================================================
    // ============================================================================

    public User(int id, String username, String password, Integer age, Date registrationDate) {
        this.setId(id);
        this.setUsername(username);
        this.setPassword(password);
        this.setAge(age);
        this.setRegistrationDate(registrationDate);
    }

    public int getId() {
        return this.id;
    }

    private void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return this.username;
    }

    private void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    private void setPassword(String password) {
        this.password = password;
    }

    public Integer getAge() {
        return this.age;
    }

    private void setAge(Integer age) {
        this.age = age;
    }

    public Date getRegistrationDate() {
        return this.registrationDate;
    }

    private void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    // ============================================================================
    // ============================================================================
    // ============================================================================


    @Override
    public String toString() {
        return String.format("ID: %d, USERNAME: %s, PASSWORD: %s, AGE: %s, DATE: %s",
                this.getId(), this.getUsername(), this.getPassword(), this.getAge(), this.getRegistrationDate());
    }
}
