package app.serviceImpl;

import app.domain.dto.AddressDto;
import app.domain.dto.PersonDto;
import app.domain.dto.PhoneNumberDto;
import app.domain.model.Address;
import app.domain.model.Person;
import app.domain.model.PhoneNumber;
import app.repositorie.PersonRepository;
import app.service.PersonService;
import org.omg.CORBA.ObjectHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;

    @Autowired
    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }


    @Override
    public void persist(PersonDto person) {
        this.personRepository.saveAndFlush(this.convertToEntity(person));
    }

    @Override
    public PersonDto findById(Long id) {
        return this.convertToDto(this.personRepository.findOne(id));
    }

    private PersonDto convertToDto(Person person) {
        PersonDto personDto = new PersonDto();
        personDto.setName(person.getName());

        AddressDto addressDto = new AddressDto();
        Address address = person.getAddress();
        addressDto.setCity(address.getCity());
        addressDto.setCountry(address.getCountry());

        personDto.setAddressDto(addressDto);

        Set<PhoneNumber> phoneNumbers = person.getPhoneNumbers();
        for (PhoneNumber phoneNumber : phoneNumbers) {
            PhoneNumberDto phoneNumberDto = new PhoneNumberDto();
            phoneNumberDto.setNumber(phoneNumber.getNumber());
            phoneNumberDto.setPersonDto(personDto);
            personDto.getPhoneNumberDtos().add(phoneNumberDto);
        }

        return personDto;
    }

    private Person convertToEntity(PersonDto personDto) {
        Person person = new Person();

        person.setName(personDto.getName());

        Address address = new Address();
        AddressDto addressDto = personDto.getAddressDto();
        address.setCity(addressDto.getCity());
        address.setCountry(addressDto.getCountry());

        person.setAddress(address);

        Set<PhoneNumber> phoneNumbers = new HashSet<>();
        Set<PhoneNumberDto> phoneNumberDtos = personDto.getPhoneNumberDtos();
        for (PhoneNumberDto phoneNumberDto : phoneNumberDtos) {
            PhoneNumber phoneNumber = new PhoneNumber();
            phoneNumber.setNumber(phoneNumberDto.getNumber());
            phoneNumber.setPerson(person);

            phoneNumbers.add(phoneNumber);
        }

        person.setPhoneNumbers(phoneNumbers);

        return person;
    }
}
