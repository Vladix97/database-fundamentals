package app.domains.dtos.jsons.inputs;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PhotographerDto implements Serializable {

    @Expose
    private String firstName;

    @Expose
    private String lastName;

    @SerializedName(value = "phone")
    @Expose
    private String phoneNumber;

    @Expose
    private Set<Integer> lenses;

    public PhotographerDto() {
        super();

        this.lenses = new HashSet<>();
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Set<Integer> getLenses() {
        return this.lenses;
    }

    public void setLenses(Set<Integer> lenses) {
        this.lenses = lenses;
    }
}
