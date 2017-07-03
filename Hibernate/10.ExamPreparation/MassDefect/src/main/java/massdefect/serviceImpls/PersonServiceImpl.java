package massdefect.serviceImpls;

import massdefect.domains.dtos.json.PersonExportJSONDto;
import massdefect.domains.dtos.json.PersonImportJSONDto;
import massdefect.domains.entities.Person;
import massdefect.domains.entities.Planet;
import massdefect.parsers.interfaces.ModelParser;
import massdefect.repositories.PersonRepository;
import massdefect.repositories.PlanetRepository;
import massdefect.serivces.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;

    private final ModelParser modelParser;

    private final PlanetRepository planetRepository;

    @Autowired
    public PersonServiceImpl(PersonRepository personRepository, ModelParser modelParser, PlanetRepository planetRepository) {
        this.personRepository = personRepository;
        this.modelParser = modelParser;
        this.planetRepository = planetRepository;
    }

    @Override
    public void create(PersonImportJSONDto personImportDto) {
        Person person = this.modelParser.convert(personImportDto, Person.class);

        Planet planet = this.planetRepository.findByName(personImportDto.getHomePlanetName());
        person.setHomePlanet(planet);

        this.personRepository.saveAndFlush(person);
    }

    @Override
    public List<PersonExportJSONDto> nonVictims() {
        List<Person> people = this.personRepository.nonVictims();

        List<PersonExportJSONDto> personExportJSONDtos = new ArrayList<>();
        for (Person person : people) {
            personExportJSONDtos.add(this.modelParser.convert(person, PersonExportJSONDto.class));
        }

        return personExportJSONDtos;
    }
}
