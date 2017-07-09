package app.domains.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "lenses")
public class Lens implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "make")
    private String make;

    @Column(name = "focal_length")
    private Integer focalLength;

    @Column(name = "max_aperture", scale = 1)
    private Double maxAperture;

    @Column(name = "compatible_make")
    private String compatibleMake;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "owner_id", referencedColumnName = "id")
    private Photographer owner;

    public Lens() {
        super();
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMake() {
        return this.make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public Integer getFocalLength() {
        return this.focalLength;
    }

    public void setFocalLength(Integer focalLength) {
        this.focalLength = focalLength;
    }

    public Double getMaxAperture() {
        return this.maxAperture;
    }

    public void setMaxAperture(Double maxAperture) {
        this.maxAperture = maxAperture;
    }

    public String getCompatibleMake() {
        return this.compatibleMake;
    }

    public void setCompatibleMake(String compatibleMake) {
        this.compatibleMake = compatibleMake;
    }

    public Photographer getOwner() {
        return this.owner;
    }

    public void setOwner(Photographer owner) {
        this.owner = owner;
    }
}
