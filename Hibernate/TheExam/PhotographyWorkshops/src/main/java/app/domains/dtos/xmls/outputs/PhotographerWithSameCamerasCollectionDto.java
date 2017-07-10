package app.domains.dtos.xmls.outputs;

import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@XmlRootElement(name = "photographers")
@XmlAccessorType(XmlAccessType.FIELD)
public class PhotographerWithSameCamerasCollectionDto implements Serializable {

    @XmlElement(name = "photographer")
    private Set<PhotographerWithSameCamerasDto> photographerWithSameCamerasDtos;

    public PhotographerWithSameCamerasCollectionDto() {
        super();

        this.photographerWithSameCamerasDtos = new HashSet<>();
    }

    public Set<PhotographerWithSameCamerasDto> getPhotographerWithSameCamerasDtos() {
        return this.photographerWithSameCamerasDtos;
    }

    public void setPhotographerWithSameCamerasDtos(Set<PhotographerWithSameCamerasDto> photographerWithSameCamerasDtos) {
        this.photographerWithSameCamerasDtos = photographerWithSameCamerasDtos;
    }
}
