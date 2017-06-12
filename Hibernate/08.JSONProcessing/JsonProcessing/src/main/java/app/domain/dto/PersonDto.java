package app.domain.dto;

import com.google.gson.annotations.Expose;

import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@XmlRootElement(name = "person")
@XmlAccessorType(XmlAccessType.FIELD)
public class PersonDto implements Serializable {

    @XmlElement(name = "name")
    @Expose
    private String name;

    @XmlElementWrapper(name = "phoneNumbers")
    @XmlElement(name = "phoneNumber")
    @Expose
    private Set<PhoneNumberDto> phoneNumberDtos;

    @XmlElement(name = "address")
    @Expose
    private AddressDto addressDto;

    public PersonDto() {
        super();

        this.phoneNumberDtos = new HashSet<>();
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<PhoneNumberDto> getPhoneNumberDtos() {
        return this.phoneNumberDtos;
    }

    public void setPhoneNumberDtos(Set<PhoneNumberDto> phoneNumberDtos) {
        this.phoneNumberDtos = phoneNumberDtos;
    }

    public AddressDto getAddressDto() {
        return this.addressDto;
    }

    public void setAddressDto(AddressDto addressDto) {
        this.addressDto = addressDto;
    }
}
