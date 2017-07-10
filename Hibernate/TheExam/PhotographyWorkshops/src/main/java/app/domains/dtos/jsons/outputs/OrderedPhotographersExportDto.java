package app.domains.dtos.jsons.outputs;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class OrderedPhotographersExportDto implements Serializable {

    @SerializedName(value = "FirstName")
    @Expose
    private String firstName;

    @SerializedName(value = "LastName")
    @Expose
    private String lastName;

    @SerializedName(value = "Phone")
    @Expose
    private String phoneNumber;

    public OrderedPhotographersExportDto() {
        super();
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
}
