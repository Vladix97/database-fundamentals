package app.domains.dtos.jsons.outputs;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class LandscapePhotographersExportDto implements Serializable {

    @SerializedName(value = "FirstName")
    @Expose
    private String firstName;

    @SerializedName(value = "LastName")
    @Expose
    private String lastName;

    @SerializedName(value = "CameraMake")
    @Expose
    private String primaryCameraMake;

    @SerializedName(value = "LensesCount")
    @Expose
    private Integer count;

    public LandscapePhotographersExportDto() {
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

    public String getPrimaryCameraMake() {
        return this.primaryCameraMake;
    }

    public void setPrimaryCameraMake(String primaryCameraMake) {
        this.primaryCameraMake = primaryCameraMake;
    }

    public Integer getCount() {
        return this.count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
