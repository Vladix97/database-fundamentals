package app.domain.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "people")
@XmlAccessorType(XmlAccessType.FIELD)
public class PeopleCollectionDto {

    @XmlElement(name = "person")
    private List<PersonDto> peopleDto;

    public PeopleCollectionDto() {
        this.peopleDto = new ArrayList<>();
    }

    public List<PersonDto> getPeopleDto() {
        return this.peopleDto;
    }

    public void setPeopleDto(List<PersonDto> peopleDto) {
        this.peopleDto = peopleDto;
    }
}
