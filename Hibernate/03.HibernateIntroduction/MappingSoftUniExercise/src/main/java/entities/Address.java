package entities;

import javax.persistence.*;

/**
 * Created by vladix on 5/24/17.
 */
@Entity
@Table(name = "addresses")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id")
    private int addressId;

    @Column(name = "address_text")
    private String addressText;

    @ManyToOne
    @JoinColumn(name = "town_id")
    private Town town;

    public Address() {
        super();
    }

    public String getAddressText() {
        return this.addressText;
    }

    public void setAddressText(String addressText) {
        this.addressText = addressText;
    }

    public Town getTown() {
        return this.town;
    }

    public void setTown(Town town) {
        this.town = town;
    }

}
