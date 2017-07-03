package massdefect.domains.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "planets")
public class Planet implements Serializable {

    private Long id;

    private String name;

    private Star sun;

    private SolarSystem solarSystem;

    private Set<Anomaly> anomalies;

    public Planet() {
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

    @Column(name = "name")
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @NotNull
    @ManyToOne
    @JoinColumn(name = "sun_id", referencedColumnName = "id")
    public Star getSun() {
        return this.sun;
    }

    public void setSun(Star sun) {
        this.sun = sun;
    }

    @NotNull
    @ManyToOne
    @JoinColumn(name = "solar_system_id", referencedColumnName = "id")
    public SolarSystem getSolarSystem() {
        return this.solarSystem;
    }

    public void setSolarSystem(SolarSystem solarSystem) {
        this.solarSystem = solarSystem;
    }

    @ManyToMany(mappedBy = "teleportPlanet")
    public Set<Anomaly> getAnomalies() {
        return this.anomalies;
    }

    public void setAnomalies(Set<Anomaly> anomalies) {
        this.anomalies = anomalies;
    }
}
