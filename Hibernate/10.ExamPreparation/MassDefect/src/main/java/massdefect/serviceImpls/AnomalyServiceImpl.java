package massdefect.serviceImpls;

import massdefect.domains.dtos.json.AnomalyExportJSONDto;
import massdefect.domains.dtos.json.AnomalyImportJSONDto;
import massdefect.domains.dtos.json.AnomalyVictimImportJSONDto;
import massdefect.domains.dtos.xml.AnomalyVictimImportXMLDto;
import massdefect.domains.dtos.xml.VictimImportXMLDto;
import massdefect.domains.entities.Anomaly;
import massdefect.domains.entities.Person;
import massdefect.domains.entities.Planet;
import massdefect.parsers.interfaces.ModelParser;
import massdefect.repositories.AnomalyRepository;
import massdefect.repositories.PersonRepository;
import massdefect.repositories.PlanetRepository;
import massdefect.serivces.AnomalyService;
import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;

@Service
@Transactional
public class AnomalyServiceImpl implements AnomalyService {

    private final AnomalyRepository anomalyRepository;

    private final ModelParser modelParser;

    private final PlanetRepository planetRepository;

    private final PersonRepository personRepository;

    @Autowired
    public AnomalyServiceImpl(AnomalyRepository anomalyRepository, ModelParser modelParser, PlanetRepository planetRepository, PersonRepository personRepository) {
        this.anomalyRepository = anomalyRepository;
        this.modelParser = modelParser;
        this.planetRepository = planetRepository;
        this.personRepository = personRepository;
    }

    @Override
    public void create(AnomalyImportJSONDto anomalyImportDto) {
        Anomaly anomaly = this.modelParser.convert(anomalyImportDto, Anomaly.class);
        Planet originPlanet = this.planetRepository.findByName(anomalyImportDto.getOriginPlanetName());
        Planet teleportPlanet = this.planetRepository.findByName(anomalyImportDto.getTeleportPlanetName());

        anomaly.setOriginPlanet(originPlanet);
        anomaly.setTeleportPlanet(teleportPlanet);

        this.anomalyRepository.saveAndFlush(anomaly);
    }

    @Override
    public void create(AnomalyVictimImportJSONDto anomalyVictimImportDto) {
        Anomaly anomaly = this.anomalyRepository.findOne(anomalyVictimImportDto.getId());
        Person person = this.personRepository.findByName(anomalyVictimImportDto.getPersonName());
        anomaly.addPerson(person);
    }

    @Override
    public void create(AnomalyVictimImportXMLDto anomalyVictimImportXMLDto) {
        Anomaly anomaly = this.modelParser.convert(anomalyVictimImportXMLDto, Anomaly.class);
        Planet originPlanet = this.planetRepository.findByName(anomalyVictimImportXMLDto.getOriginPlanetName());
        Planet teleportPlanet = this.planetRepository.findByName(anomalyVictimImportXMLDto.getTeleportPlanetName());

        anomaly.setOriginPlanet(originPlanet);
        anomaly.setTeleportPlanet(teleportPlanet);

        Set<VictimImportXMLDto> victimImportDtos = anomalyVictimImportXMLDto.getVictimImportDtos();
        for (VictimImportXMLDto victimImportDto : victimImportDtos) {
            Person person = this.personRepository.findByName(victimImportDto.getName());
            anomaly.addPerson(person);
        }

        this.anomalyRepository.saveAndFlush(anomaly);
    }

    @Override
    public AnomalyExportJSONDto anomalyWithMostVictims() {
        List<Anomaly> anomalies = this.anomalyRepository.anomaliesOrderedByVictimsDesc();

        Anomaly anomaly = anomalies.iterator().next();
        PropertyMap<Anomaly,AnomalyExportJSONDto> propertyMap = new PropertyMap<Anomaly, AnomalyExportJSONDto>() {
            @Override
            protected void configure() {
                map(source.getPeople().size(), destination.getVictimsCount());
            }
        };
        AnomalyExportJSONDto anomalyExportJSONDto = this.modelParser.convert(anomaly, AnomalyExportJSONDto.class, propertyMap);
        System.out.println();
        return anomalyExportJSONDto;
    }
}
