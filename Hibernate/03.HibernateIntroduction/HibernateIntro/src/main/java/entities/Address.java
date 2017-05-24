package entities;

import javax.persistence.*;

/**
 * Created by vladix on 5/24/17.
 */
@Entity
@Table(name = "addresses", schema = "soft_uni", catalog = "")
public class Address {
    private Integer addressId;
    private String addressText;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id")
    public Integer getAddressId() {
        return this.addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    @Basic
    @Column(name = "address_text")
    public String getAddressText() {
        return this.addressText;
    }

    public void setAddressText(String addressText) {
        this.addressText = addressText;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Address address = (Address) o;

        if (addressId != null ? !addressId.equals(address.addressId) : address.addressId != null) return false;
        if (addressText != null ? !addressText.equals(address.addressText) : address.addressText != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = addressId != null ? addressId.hashCode() : 0;
        result = 31 * result + (addressText != null ? addressText.hashCode() : 0);
        return result;
    }
}
