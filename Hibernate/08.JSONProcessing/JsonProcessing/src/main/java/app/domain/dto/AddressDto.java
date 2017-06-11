package app.domain.dto;

import com.google.gson.annotations.Expose;

import java.io.Serializable;

public class AddressDto implements Serializable {

    @Expose
    private String country;

    @Expose
    private String city;

    public AddressDto() {
        super();
    }

    public String getCountry() {
        return this.country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
