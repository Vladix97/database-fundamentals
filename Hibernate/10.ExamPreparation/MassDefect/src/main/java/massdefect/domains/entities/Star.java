package massdefect.domains.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "stars")
public class Star implements Serializable {

    private Long id;

    private String name;

    private SolarSystem solarSystem;

    public Star() {
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
    @JoinColumn(name = "solar_system_id", referencedColumnName = "id")
    public SolarSystem getSolarSystem() {
        return this.solarSystem;
    }

    public void setSolarSystem(SolarSystem solarSystem) {
        this.solarSystem = solarSystem;
    }
}
