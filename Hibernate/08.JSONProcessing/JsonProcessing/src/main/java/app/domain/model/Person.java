package app.domain.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "people")
public class Person implements Serializable {

    private Long id;

    private String name;

    private Set<PhoneNumber> phoneNumbers;

    private Address address;

    public Person() {
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

    @Column(name = "name")
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL, targetEntity = PhoneNumber.class, fetch = FetchType.EAGER)
    public Set<PhoneNumber> getPhoneNumbers() {
        return this.phoneNumbers;
    }

    public void setPhoneNumbers(Set<PhoneNumber> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "adderss_id", referencedColumnName = "id")
    public Address getAddress() {
        return this.address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
