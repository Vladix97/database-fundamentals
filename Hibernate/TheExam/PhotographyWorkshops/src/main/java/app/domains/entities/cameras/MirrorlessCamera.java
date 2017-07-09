package app.domains.entities.cameras;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "Mirrorless")
public class MirrorlessCamera extends AbstractCamera {

    @Column(name = "max_video_resolution")
    private String maxVideoResolution;

    @Column(name = "max_frame_rate")
    private Integer maxFrameRate;

    public MirrorlessCamera() {
        super();
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
