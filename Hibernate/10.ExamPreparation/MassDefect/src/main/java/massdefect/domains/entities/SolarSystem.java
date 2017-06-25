package massdefect.domains.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "solar_systems")
public class SolarSystem implements Serializable {

    private Long id;

    private String name;

    public SolarSystem() {
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
}
