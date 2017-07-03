package massdefect.domains.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "people")
public class Person implements Serializable {

    private Long id;

    private String name;

    private Planet homePlanet;

    private Set<Anomaly> anomalies;

    public Person() {
        super();

        this.anomalies = new HashSet<>();
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

    @NotNull
    @Column(name = "name")
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @NotNull
    @ManyToOne
    @JoinColumn(name = "home_planet_id", referencedColumnName = "id")
    public Planet getHomePlanet() {
        return this.homePlanet;
    }

    public void setHomePlanet(Planet homePlanet) {
        this.homePlanet = homePlanet;
    }

    @ManyToMany(mappedBy = "people")
    public Set<Anomaly> getAnomalies() {
        return this.anomalies;
    }

    public void setAnomalies(Set<Anomaly> anomalies) {
        this.anomalies = anomalies;
    }
}
