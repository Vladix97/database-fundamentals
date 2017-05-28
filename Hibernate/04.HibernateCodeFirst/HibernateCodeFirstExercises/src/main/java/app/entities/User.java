package app.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "users")
public class User {

    private static final String EMAIL_PATTERN = "" +
            "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$";

    private static final String PASSWORD_PATTERN =
            "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";
    public static final int ONE_MB = 1048576;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "INT UNSIGNED")
    private Long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String email;

    @Column(name = "profile_picture",  columnDefinition = "LONGBLOB")
    private byte[] profilePicture;

    @Column(name = "registered_on", columnDefinition = "DATETIME")
    private Date registeredOn;

    @Column(name = "last_time_logged_in")
    private Date lastTimeLoggedIn;

    @Basic
    private Integer age;

    @Column(name = "is_deleted")
    private Boolean isDeleted;

    public User() {
        super();
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        if (!(username.length() >= 4 && username.length() <= 30)) {
            throw new IllegalArgumentException("Invalid Username!");
        }

        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        if (!password.matches(PASSWORD_PATTERN)) {
            throw new IllegalArgumentException("Invalid Password!");
        }

        this.password = password;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        if (!email.matches(EMAIL_PATTERN)) {
            throw new IllegalArgumentException("Invalid Email");
        }

        this.email = email;
    }

    public byte[] getProfilePicture() {
        return this.profilePicture;
    }

    public void setProfilePicture(byte[] profilePicture) {
        if(profilePicture.length > ONE_MB){
            throw new IllegalArgumentException("Profile Picture too big");
        }

        this.profilePicture = profilePicture;
    }

    public Date getRegisteredOn() {
        return this.registeredOn;
    }

    public void setRegisteredOn(Date registeredOn) {
        this.registeredOn = registeredOn;
    }

    public Date getLastTimeLoggedIn() {
        return this.lastTimeLoggedIn;
    }

    public void setLastTimeLoggedIn(Date lastTimeLoggedIn) {
        this.lastTimeLoggedIn = lastTimeLoggedIn;
    }

    public Integer getAge() {
        return this.age;
    }

    public void setAge(Integer age) {
        if (!(age >= 1 && age <= 120)) {
            throw new IllegalArgumentException("Invalid Age");
        }

        this.age = age;
    }

    public Boolean getDeleted() {
        return this.isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }


}
