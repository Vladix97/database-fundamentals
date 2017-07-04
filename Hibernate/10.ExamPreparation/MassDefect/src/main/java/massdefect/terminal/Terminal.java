package massdefect.terminal;

import massdefect.domains.dtos.json.*;
import massdefect.domains.dtos.xml.AnomalyCollectionXMLDto;
import massdefect.domains.dtos.xml.AnomalyXMLDto;
import massdefect.ios.interfaces.ConsoleIO;
import massdefect.ios.interfaces.FileIO;
import massdefect.parsers.interfaces.FileParser;
import massdefect.serivces.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.List;
import java.util.Set;

@Component
public class Terminal implements CommandLineRunner {

    private final ConsoleIO consoleIO;

    private final FileIO fileIO;

    private final FileParser jsonParser;

    private final FileParser xmlParser;

    private final SolarSystemService solarSystemService;

    private final StarService starService;

    private final PlanetService planetService;

    private final PersonService personService;

    private final AnomalyService anomalyService;

    @Autowired
    public Terminal(
            FileIO fileIO,
            ConsoleIO consoleIO,
            @Qualifier(value = "JSONParser") FileParser jsonParser,
            @Qualifier(value = "XMLParser") FileParser xmlParser,
            SolarSystemService solarSystemService,
            StarService starService,
            PlanetService planetService,
            PersonService personService,
            AnomalyService anomalyService) {
        this.solarSystemService = solarSystemService;
        this.fileIO = fileIO;
        this.consoleIO = consoleIO;
        this.jsonParser = jsonParser;
        this.xmlParser = xmlParser;
        this.starService = starService;
        this.planetService = planetService;
        this.personService = personService;
        this.anomalyService = anomalyService;
    }

    @Override
    public void run(String... strings) throws Exception {
        System.out.println("** LIVE ***");
        System.out.println("** LIVE ***");
        System.out.println("** LIVE ***");

        // Imports
        importJSONSolarSystems();
        importJSONStars();
        importJSONPlanets();
        importJSONPeople();
        importJSONAnomalies();
        importJSONAnomaliesVictims();
        importXMLAnomaliesVictims();

        // Exports
        exportJSONAllNonOriginPlanets();
        exportNonVictimPeople();
        exportJSONMostAffectingAnomaly();
        exportAnomaliesToXML();
    }

    private void importJSONSolarSystems() {
        SolarSystemImportJSONDto[] solarSystemImportDtos = null;
        try {
            solarSystemImportDtos = this.jsonParser.read(SolarSystemImportJSONDto[].class, "/files/json/input/solar-systems.json");
        } catch (IOException | JAXBException e) {
            e.printStackTrace();
        }

        for (SolarSystemImportJSONDto solarSystemImportDto : solarSystemImportDtos) {
            try {
                this.solarSystemService.create(solarSystemImportDto);
                this.consoleIO.write(String.format("Successfully imported Solar System %s.", solarSystemImportDto.getName()));
            } catch (Exception e) {
                this.consoleIO.write(String.format("Invalid Solar System"));
            }
        }
    }

    private void importJSONStars() {
        StarImportJSONDto[] starImportDtos = null;
        try {
            starImportDtos = this.jsonParser.read(StarImportJSONDto[].class, "/files/json/input/stars.json");
        } catch (IOException | JAXBException e) {
            e.printStackTrace();
        }

        for (StarImportJSONDto starImportDto : starImportDtos) {
            try {
                this.starService.create(starImportDto);
                this.consoleIO.write(String.format("Successfully imported Star %s.", starImportDto.getName()));
            } catch (Exception e) {
                this.consoleIO.write(String.format("Invalid Star"));
            }
        }
    }

    private void importJSONPlanets() {
        PlanetImportJSONDto[] planetImportDtos = null;

        try {
            planetImportDtos = this.jsonParser.read(PlanetImportJSONDto[].class, "/files/json/input/planets.json");
        } catch (IOException | JAXBException e) {
            e.printStackTrace();
        }

        for (PlanetImportJSONDto planetImportDto : planetImportDtos) {
            try {
                this.planetService.create(planetImportDto);
                this.consoleIO.write(String.format("Successfully imported Planet %s.", planetImportDto.getName()));
            } catch (Exception e) {
                this.consoleIO.write(String.format("Invalid Planet"));
            }
        }
    }

    private void importJSONPeople() {
        PersonImportJSONDto[] personImportDtos = null;

        try {
            personImportDtos = this.jsonParser.read(PersonImportJSONDto[].class, "/files/json/input/persons.json");
        } catch (IOException | JAXBException e) {
            e.printStackTrace();
        }

        for (PersonImportJSONDto personImportDto : personImportDtos) {
            try {
                this.personService.create(personImportDto);
                this.consoleIO.write(String.format("Successfully imported Person %s.", personImportDto.getName()));
            } catch (Exception e) {
                this.consoleIO.write(String.format("Invalid Person"));
            }
        }
    }

    private void importJSONAnomalies() {
        AnomalyImportJSONDto[] anomalyImportDtos = null;

        try {
            anomalyImportDtos = this.jsonParser.read(AnomalyImportJSONDto[].class, "/files/json/input/anomalies.json");
        } catch (IOException | JAXBException e) {
            e.printStackTrace();
        }

        for (AnomalyImportJSONDto anomalyImportDto : anomalyImportDtos) {
            try {
                this.anomalyService.create(anomalyImportDto);
                this.consoleIO.write(String.format("Successfully imported Anomaly %s %s.",
                        anomalyImportDto.getOriginPlanetName(), anomalyImportDto.getOriginPlanetName()));
            } catch (Exception e) {
                this.consoleIO.write(String.format("Invalid Anomaly"));
            }
        }
    }

    private void importJSONAnomaliesVictims() {
        AnomalyVictimImportJSONDto[] anomalyVictimImportDtos = null;

        try {
            anomalyVictimImportDtos = this.jsonParser.read(AnomalyVictimImportJSONDto[].class, "/files/json/input/anomaly-victims.json");
        } catch (IOException | JAXBException e) {
            e.printStackTrace();
        }

        for (AnomalyVictimImportJSONDto anomalyVictimImportDto : anomalyVictimImportDtos) {
            try {
                this.anomalyService.create(anomalyVictimImportDto);
                this.consoleIO.write(String.format("Successfully imported Anomaly - Victim %s %s.",
                        anomalyVictimImportDto.getId(), anomalyVictimImportDto.getPersonName()));
            } catch (Exception e) {
                this.consoleIO.write(String.format("Invalid Anomaly - Victim"));
            }
        }
    }

    private void importXMLAnomaliesVictims() {
        AnomalyCollectionXMLDto anomalyVictimCollectionImportXMLDto = null;

        try {
            anomalyVictimCollectionImportXMLDto =
                    this.xmlParser.read(AnomalyCollectionXMLDto.class, "/files/xml/input/new-anomalies.xml");
        } catch (JAXBException | IOException e) {
            e.printStackTrace();
        }

        Set<AnomalyXMLDto> anomalyVictimImportXMLDtos =
                anomalyVictimCollectionImportXMLDto.getAnomalyXMLDtos();
        for (AnomalyXMLDto anomalyVictimImportXMLDto : anomalyVictimImportXMLDtos) {
            try {
                this.anomalyService.create(anomalyVictimImportXMLDto);
                this.consoleIO.write(String.format("Successfully imported Anomaly - Victim XML %s %s.",
                        anomalyVictimImportXMLDto.getOriginPlanetName(), anomalyVictimImportXMLDto.getTeleportPlanetName()));
            } catch (Exception e) {
                this.consoleIO.write(String.format("Invalid Anomaly - Victim XML"));
            }
        }
    }

    private void exportJSONAllNonOriginPlanets() {
        List<PlanetExportJSONDto> planetExportJSONDtos = this.planetService.allNonOriginPlanets();

        try {
            this.jsonParser.write(planetExportJSONDtos, "src/main/resources/files/json/output/planets.json");
        } catch (IOException | JAXBException e) {
            e.printStackTrace();
        }
    }

    private void exportNonVictimPeople() {
        List<PersonExportJSONDto> personExportJSONDtos = this.personService.nonVictims();

        try {
            this.jsonParser.write(personExportJSONDtos, "src/main/resources/files/json/output/people.json");
        } catch (IOException | JAXBException e) {
            e.printStackTrace();
        }
    }

    private void exportJSONMostAffectingAnomaly() {
        AnomalyExportJSONDto anomalyExportJSONDto = this.anomalyService.anomalyWithMostVictims();

        try {
            this.jsonParser.write(anomalyExportJSONDto, "src/main/resources/files/json/output/anomaly.json");
        } catch (IOException | JAXBException e) {
            e.printStackTrace();
        }
    }

    private void exportAnomaliesToXML(){
        AnomalyCollectionXMLDto anomaliesXMLDto = this.anomalyService.findAllAnomalies();
        try {
            this.xmlParser.write(anomaliesXMLDto, "src/main/resources/files/xml/output/anomalies.xml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
