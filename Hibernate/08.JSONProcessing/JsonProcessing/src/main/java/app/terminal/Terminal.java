package app.terminal;

import app.domain.dto.AddressDto;
import app.domain.dto.PeopleCollectionDto;
import app.domain.dto.PersonDto;
import app.domain.dto.PhoneNumberDto;
import app.io.JsonParser;
import app.io.XmlParser;
import app.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class Terminal implements CommandLineRunner {

    private final PersonService personService;

    private final JsonParser jsonParser;

    private final XmlParser xmlParser;

    @Autowired
    public Terminal(PersonService personService, JsonParser jsonParser, XmlParser xmlParser) {
        this.personService = personService;
        this.jsonParser = jsonParser;
        this.xmlParser = xmlParser;
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

//        this.exportManyToJson();

//        this.importFromJson();

//        this.importManyFromJson();

//        this.exportToXml();

//        this.importFromXml();

//        this.exportManyToXml();

        this.importManyFromXml();
    }

    private void importManyFromXml() {
        try {
            PeopleCollectionDto peopleCollectionDto = this.xmlParser.importXml(
                    PeopleCollectionDto.class,
                    "src/main/resources/files/input/xml/people.xml"
            );

            for (PersonDto personDto : peopleCollectionDto.getPeopleDto()) {
                this.personService.persist(personDto);
            }
        } catch (IOException | JAXBException e) {
            e.printStackTrace();
        }
    }

    private void importFromXml() {
        try {
            PersonDto personDto = this.xmlParser.importXml(
                    PersonDto.class,
                    "src/main/resources/files/input/xml/person.xml"
            );
            this.personService.persist(personDto);
        } catch (IOException | JAXBException e) {
            e.printStackTrace();
        }
    }

    private void exportToXml() {
        PersonDto personDto = this.getPersonDto();
        try {
            this.xmlParser.writeXML(personDto, "src/main/resources/files/output/xml/person.xml");
        } catch (JAXBException | FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void exportManyToXml() {
        PeopleCollectionDto personDto = new PeopleCollectionDto();
        personDto.getPeopleDto().add(this.getPersonDto());
        personDto.getPeopleDto().add(this.getPersonDto());
        personDto.getPeopleDto().add(this.getPersonDto());
        personDto.getPeopleDto().add(this.getPersonDto());

        try {
            this.xmlParser.writeXML(personDto, "src/main/resources/files/output/xml/people.xml");
        } catch (JAXBException | FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void importManyFromJson() {
        try {
            PersonDto[] personDtos = this.jsonParser.importJson(PersonDto[].class, "/files/input/json/people.json");
            for (PersonDto personDto : personDtos) {
                this.personService.persist(personDto);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void exportManyToJson() {
        PersonDto personDto = this.getPersonDto();
        PersonDto personDto1 = this.getPersonDto();
        List<PersonDto> personDtos = new ArrayList<>();
        personDtos.add(personDto);
        personDtos.add(personDto1);

        try {
            this.jsonParser.exportJson(personDtos, "src/main/resources/files/output/json/people.json");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void importFromJson() {
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
