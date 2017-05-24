package entities;

import javax.persistence.*;

/**
 * Created by vladix on 5/24/17.
 */
@Entity
@Table(name = "towns", schema = "soft_uni", catalog = "")
public class Town {
    private Integer townId;
    private String name;

    @Id
    @Column(name = "town_id")
    public Integer getTownId() {
        return this.townId;
    }

    public void setTownId(Integer townId) {
        this.townId = townId;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Town town = (Town) o;

        if (townId != null ? !townId.equals(town.townId) : town.townId != null) return false;
        if (name != null ? !name.equals(town.name) : town.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = townId != null ? townId.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
