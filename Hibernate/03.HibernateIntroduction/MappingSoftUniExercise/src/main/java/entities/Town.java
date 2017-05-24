package entities;

import javax.persistence.*;

/**
 * Created by vladix on 5/24/17.
 */
@Entity
@Table(name = "towns")
public class Town {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "town_id")
    private int townId;

    @Basic
    private String name;

    public Town() {
        super();
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
