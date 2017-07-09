package app.domains.dtos.jsons.inputs;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class LensDto implements Serializable {

    @Expose
    private String make;

    @Expose
    private Integer focalLength;

    @Expose
    private Double maxAperture;

    @SerializedName(value = "compatibleWith")
    @Expose
    private String compatibleMake;

    public LensDto() {
        super();
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
}
