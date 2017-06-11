package app.domain.dto;

import com.google.gson.annotations.Expose;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class PersonDto implements Serializable {

    @Expose
    private String name;

    @Expose
    private Set<PhoneNumberDto> phoneNumberDtos;

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
