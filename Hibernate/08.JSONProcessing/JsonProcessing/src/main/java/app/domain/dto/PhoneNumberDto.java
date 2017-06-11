package app.domain.dto;

import com.google.gson.annotations.Expose;

import java.io.Serializable;

public class PhoneNumberDto implements Serializable {

    @Expose
    private String number;

//    @Expose
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
