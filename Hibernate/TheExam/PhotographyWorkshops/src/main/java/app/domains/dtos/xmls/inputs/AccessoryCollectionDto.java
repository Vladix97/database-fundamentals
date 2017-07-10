package app.domains.dtos.xmls.inputs;

import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@XmlRootElement(name = "accessories")
@XmlAccessorType(XmlAccessType.FIELD)
public class AccessoryCollectionDto implements Serializable {

    @XmlElement(name = "accessory")
    private Set<AccessoryDto> accessoryDtos;

    public AccessoryCollectionDto() {
        super();

        this.accessoryDtos = new HashSet<>();
    }

    public Set<AccessoryDto> getAccessoryDtos() {
        return this.accessoryDtos;
    }

    public void setAccessoryDtos(Set<AccessoryDto> accessoryDtos) {
        this.accessoryDtos = accessoryDtos;
    }
}
