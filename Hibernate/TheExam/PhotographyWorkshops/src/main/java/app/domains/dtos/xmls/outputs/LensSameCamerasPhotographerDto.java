package app.domains.dtos.xmls.outputs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@XmlRootElement(name = "lens")
@XmlAccessorType(XmlAccessType.FIELD)
public class LensSameCamerasPhotographerDto implements Serializable {

    @XmlAttribute
    private String focalLength;

    @XmlAttribute
    private String maxAperture;

    public LensSameCamerasPhotographerDto() {
        super();
    }

    public String getFocalLength() {
        return this.focalLength;
    }

    public void setFocalLength(String focalLength) {
        this.focalLength = focalLength + "mm";
    }

    public String getMaxAperture() {
        return this.maxAperture;
    }

    public void setMaxAperture(String maxAperture) {
        this.maxAperture = "f" + maxAperture;
    }
}