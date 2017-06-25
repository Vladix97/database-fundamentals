package massdefect.domains.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "planets")
public class Planet implements Serializable {

    private Long id;

    private String name;

    private Star sun;

    private SolarSystem solarSystem;

    public Planet() {
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

    @ManyToOne
    @JoinColumn(name = "sun_id", referencedColumnName = "id")
    public Star getSun() {
        return this.sun;
    }

    public void setSun(Star sun) {
        this.sun = sun;
    }

    @ManyToOne
    @JoinColumn(name = "solar_system_id", referencedColumnName = "id")
    public SolarSystem getSolarSystem() {
        return this.solarSystem;
    }

    public void setSolarSystem(SolarSystem solarSystem) {
        this.solarSystem = solarSystem;
    }
}
