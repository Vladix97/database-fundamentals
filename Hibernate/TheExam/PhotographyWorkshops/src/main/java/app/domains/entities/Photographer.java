package app.domains.entities;

import app.domains.entities.cameras.AbstractCamera;
import app.validation.annotations.Phone;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "photographers")
public class Photographer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull
    @Column(name = "first_name")
    private String firstName;

    @NotNull
    @Size(min = 2, max = 50)
    @Column(name = "last_name")
    private String lastName;

    @Phone
    @Column(name = "phone_number")
    private String phoneNumber;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "primary_camera_id")
    private AbstractCamera primaryCamera;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "secondary_camera_id")
    private AbstractCamera secondaryCamera;

    @OneToMany(mappedBy = "owner")
    private Set<Lens> lenses;

    public Photographer() {
        super();

        this.lenses = new HashSet<>();
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public AbstractCamera getPrimaryCamera() {
        return this.primaryCamera;
    }

    public void setPrimaryCamera(AbstractCamera primaryCamera) {
        this.primaryCamera = primaryCamera;
    }

    public AbstractCamera getSecondaryCamera() {
        return this.secondaryCamera;
    }

    public void setSecondaryCamera(AbstractCamera secondaryCamera) {
        this.secondaryCamera = secondaryCamera;
    }

    public Set<Lens> getLenses() {
        return this.lenses;
    }

    public void setLenses(Set<Lens> lenses) {
        this.lenses = lenses;
    }

    public String getName() {
        return this.firstName + " " + this.lastName;
    }

    public String getCamera() {
        return this.primaryCamera.getMake() + " " + this.primaryCamera.getModel();
    }
}
