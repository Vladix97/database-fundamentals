package massdefect.terminal;

import massdefect.domains.dtos.json.SolarSystemImportDto;
import massdefect.domains.dtos.json.StarImportDto;
import massdefect.domains.entities.Star;
import massdefect.ios.interfaces.ConsoleIO;
import massdefect.ios.interfaces.FileIO;
import massdefect.parsers.interfaces.FileParser;
import massdefect.serivces.SolarSystemService;
import massdefect.serivces.StarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBException;
import java.io.IOException;

@Component
public class Terminal implements CommandLineRunner {

    private final ConsoleIO consoleIO;

    private final FileIO fileIO;

    private final FileParser jsonParser;

    private final FileParser xmlParser;

    private final SolarSystemService solarSystemService;

    private final StarService starService;

    @Autowired
    public Terminal(
            FileIO fileIO,
            ConsoleIO consoleIO,
            @Qualifier(value = "JSONParser") FileParser jsonParser,
            @Qualifier(value = "XMLParser") FileParser xmlParser,
            SolarSystemService solarSystemService, StarService starService) {
        this.solarSystemService = solarSystemService;
        this.fileIO = fileIO;
        this.consoleIO = consoleIO;
        this.jsonParser = jsonParser;
        this.xmlParser = xmlParser;
        this.starService = starService;
    }

    @Override
    public void run(String... strings) throws Exception {
        System.out.println("** LIVE ***");
        System.out.println("** LIVE ***");
        System.out.println("** LIVE ***");

        importSolarSystems();
        importStars();
    }

    private void importSolarSystems() {
        SolarSystemImportDto[] solarSystemImportDtos = null;
        try {
            solarSystemImportDtos = this.jsonParser.read(SolarSystemImportDto[].class, "/files/json/input/solar-systems.json");
        } catch (IOException | JAXBException e) {
            e.printStackTrace();
        }

        for (SolarSystemImportDto solarSystemImportDto : solarSystemImportDtos) {
            try {
                this.solarSystemService.create(solarSystemImportDto);
                this.consoleIO.write(String.format("Successfully imported Solar System %s.", solarSystemImportDto.getName()));
            } catch (Exception e) {
                this.consoleIO.write(String.format("Error"));
            }
        }
    }

    private void importStars() {
        StarImportDto[] starImportDtos = null;
        try {
            starImportDtos = this.jsonParser.read(StarImportDto[].class, "/files/json/input/stars.json");
        } catch (IOException | JAXBException e) {
            e.printStackTrace();
        }

        for (StarImportDto starImportDto : starImportDtos) {
            try {
                this.starService.create(starImportDto);
                this.consoleIO.write(String.format("Successfully imported Star %s.", starImportDto.getName()));
            } catch (Exception e) {
                this.consoleIO.write(String.format("Error"));
            }
        }
    }
}
