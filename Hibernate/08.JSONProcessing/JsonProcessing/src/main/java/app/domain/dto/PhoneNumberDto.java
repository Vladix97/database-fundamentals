package app.domain.dto;

import com.google.gson.annotations.Expose;

import javax.xml.bind.annotation.*;
import java.io.Serializable;

@XmlRootElement(name = "phoneNumber")
@XmlAccessorType(XmlAccessType.FIELD)
public class PhoneNumberDto implements Serializable {

    @XmlElement(name = "number")
    @Expose
    private String number;

    @XmlTransient
    private PersonDto personDto;

    public PhoneNumberDto() {
        super();
    }

    public String getNumber() {
        return this.number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public PersonDto getPersonDto() {
        return this.personDto;
    }

    public void setPersonDto(PersonDto personDto) {
        this.personDto = personDto;
    }
}
