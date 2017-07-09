package app.domains.dtos.jsons.inputs;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class CameraDto implements Serializable {

    @Expose
    private String type;

    @Expose
    private String make;

    @Expose
    private String model;

    @Expose
    private Boolean isFullFrame;

    @Expose
    private Integer minISO;

    @Expose
    private Integer maxISO;

    @SerializedName(value = "MaxShutterSpeed")
    @Expose
    private Integer maxShutterSpeed;

    @Expose
    private String maxVideoResolution;

    @Expose
    private Integer maxFrameRate;

    public CameraDto() {
        super();
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMake() {
        return this.make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return this.model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Boolean getFullFrame() {
        return this.isFullFrame;
    }

    public void setFullFrame(Boolean fullFrame) {
        isFullFrame = fullFrame;
    }

    public Integer getMinISO() {
        return this.minISO;
    }

    public void setMinISO(Integer minISO) {
        this.minISO = minISO;
    }

    public Integer getMaxISO() {
        return this.maxISO;
    }

    public void setMaxISO(Integer maxISO) {
        this.maxISO = maxISO;
    }

    public Integer getMaxShutterSpeed() {
        return this.maxShutterSpeed;
    }

    public void setMaxShutterSpeed(Integer maxShutterSpeed) {
        this.maxShutterSpeed = maxShutterSpeed;
    }

    public String getMaxVideoResolution() {
        return this.maxVideoResolution;
    }

    public void setMaxVideoResolution(String maxVideoResolution) {
        this.maxVideoResolution = maxVideoResolution;
    }

    public Integer getMaxFrameRate() {
        return this.maxFrameRate;
    }

    public void setMaxFrameRate(Integer maxFrameRate) {
        this.maxFrameRate = maxFrameRate;
    }
}
