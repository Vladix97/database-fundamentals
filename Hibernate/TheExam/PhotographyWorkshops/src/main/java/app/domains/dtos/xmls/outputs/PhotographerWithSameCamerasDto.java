package app.domains.dtos.xmls.outputs;

import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@XmlRootElement(name = "photographer")
@XmlAccessorType(XmlAccessType.FIELD)
public class PhotographerWithSameCamerasDto implements Serializable {

    @XmlAttribute(name = "name")
    private String name;

    @XmlAttribute(name = "primary-camera")
    private String camera;

    @XmlElementWrapper(name = "lenses")
    @XmlElement(name = "lens")
    private Set<LensSameCamerasPhotographerDto> lenses;

    public PhotographerWithSameCamerasDto() {
        super();

        this.lenses = new HashSet<>();
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrimaryCamera() {
        return this.camera;
    }

    public void setPrimaryCamera(String camera) {
        this.camera = camera;
    }

    public Set<LensSameCamerasPhotographerDto> getLensSameCamerasPhotographerDtos() {
        return this.lenses;
    }

    public void setLensSameCamerasPhotographerDtos(Set<LensSameCamerasPhotographerDto> lenses) {
        this.lenses = lenses;
    }
}
