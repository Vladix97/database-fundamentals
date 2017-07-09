package app.domains.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "accessories")
public class Accessory implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Photographer owner;

    public Accessory() {
        super();
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Photographer getOwner() {
        return this.owner;
    }

    public void setOwner(Photographer owner) {
        this.owner = owner;
    }
}
