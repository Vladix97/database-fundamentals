package app.domain.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "phone_numbers")
public class PhoneNumber implements Serializable {

    private Long id;

    private String number;

    private Person person;

    public PhoneNumber() {
        super();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "number")
    public String getNumber() {
        return this.number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "person_id", referencedColumnName = "id")
    public Person getPerson() {
        return this.person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
