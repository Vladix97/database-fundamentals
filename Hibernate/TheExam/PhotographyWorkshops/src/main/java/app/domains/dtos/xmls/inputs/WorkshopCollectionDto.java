package app.domains.dtos.xmls.inputs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.HashSet;
import java.util.Set;

@XmlRootElement(name = "workshops")
@XmlAccessorType(XmlAccessType.FIELD)
public class WorkshopCollectionDto {

    @XmlElement(name = "workshop")
    private Set<WorkshopDto> workshopDtos;

    public WorkshopCollectionDto() {
        super();

        this.workshopDtos = new HashSet<>();
    }

    public Set<WorkshopDto> getWorkshopDtos() {
        return this.workshopDtos;
    }

    public void setWorkshopDtos(Set<WorkshopDto> workshopDtos) {
        this.workshopDtos = workshopDtos;
    }
}
