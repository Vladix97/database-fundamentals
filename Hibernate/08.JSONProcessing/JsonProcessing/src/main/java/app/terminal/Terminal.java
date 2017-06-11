package app.terminal;

import app.domain.dto.AddressDto;
import app.domain.dto.PersonDto;
import app.domain.dto.PhoneNumberDto;
import app.io.JsonParser;
import app.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class Terminal implements CommandLineRunner {

    private final PersonService personService;

    private final JsonParser jsonParser;

    @Autowired
    public Terminal(PersonService personService, JsonParser jsonParser) {
        this.personService = personService;
        this.jsonParser = jsonParser;
    }

    @Override
    public void run(String... strings) {
        System.out.println("### LIVE ### LIVE ### LIVE ###");
        System.out.println("### LIVE ### LIVE ### LIVE ###");
        System.out.println("### LIVE ### LIVE ### LIVE ###");

        //==================================================
        //==================================================
        //==================================================

//        this.personService.persist(this.getPersonDto());

//        this.exportToJson();

        this.importJson();
    }

    private void importJson() {
        try {
            PersonDto personDtoFromJSON = null;
            personDtoFromJSON = this.jsonParser.importJson(PersonDto.class, "/files/input/json/person.json");
            System.out.println("DEBUG");
            this.personService.persist(personDtoFromJSON);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void exportToJson() {
        try {
            PersonDto personDto = this.personService.findById(1L);
            this.jsonParser.exportJson(personDto, "src/main/resources/files/output/json/person.json");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private PersonDto getPersonDto() {
        PersonDto personDto = new PersonDto();
        personDto.setName("GOSHO");

        AddressDto addressDto = new AddressDto();
        addressDto.setCountry("GERMANY");
        addressDto.setCity("BERLIN");

        personDto.setAddressDto(addressDto);

        PhoneNumberDto phoneNumberDto = new PhoneNumberDto();
        phoneNumberDto.setNumber("000-111-222-333-444-555");
        phoneNumberDto.setPersonDto(personDto);

        personDto.getPhoneNumberDtos().add(phoneNumberDto);

        return personDto;
    }
}
