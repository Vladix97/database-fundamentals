package massdefect.domains.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "anomalies")
public class Anomalie implements Serializable {

    private Long id;

    private Planet originPlanet;

    private Planet teleportPlanet;

    public Anomalie() {
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
}
