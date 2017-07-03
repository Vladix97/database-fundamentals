package massdefect.domains.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "anomalies")
public class Anomaly implements Serializable {

    private Long id;

    private Planet originPlanet;

    private Planet teleportPlanet;

    private Set<Person> people;

    public Anomaly() {
        super();

        this.people = new HashSet<>();
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

    @ManyToOne
    @JoinColumn(name = "origin_planet_id", referencedColumnName = "id")
    public Planet getOriginPlanet() {
        return this.originPlanet;
    }

    public void setOriginPlanet(Planet originPlanet) {
        this.originPlanet = originPlanet;
    }

    @ManyToOne
    @JoinColumn(name = "teleport_planet_id", referencedColumnName = "id")
    public Planet getTeleportPlanet() {
        return this.teleportPlanet;
    }

    public void setTeleportPlanet(Planet teleportPlanet) {
        this.teleportPlanet = teleportPlanet;
    }

    @ManyToMany
    @JoinTable(name = "anomalies_victims",
            joinColumns = @JoinColumn(name = "anomaly_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "person_id", referencedColumnName = "id"))
    public Set<Person> getPeople() {
        return this.people;
    }

    public void setPeople(Set<Person> people) {
        this.people = people;
    }

    public void addPerson(Person person) {
        Set<Person> people = this.getPeople();
        people.add(person);
    }
}
