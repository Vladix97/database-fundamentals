package app.terminal;

import app.domains.dtos.jsons.inputs.CameraDto;
import app.domains.dtos.jsons.inputs.LensDto;
import app.domains.dtos.jsons.inputs.PhotographerDto;
import app.ios.interfaces.ConsoleIO;
import app.ios.interfaces.FileIO;
import app.parsers.XMLParser;
import app.parsers.interfaces.FileParser;
import app.services.CameraService;
import app.services.LensService;
import app.services.PhotographerService;
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

    private final FileParser JSONParser;

    private final XMLParser XMLParser;

    private final LensService lensService;

    private final CameraService cameraService;

    private final PhotographerService photographerService;

    @Autowired
    public Terminal(
            ConsoleIO consoleIO,
            FileIO fileIO,
            @Qualifier(value = "JSONParser") FileParser JSONParser,
            @Qualifier(value = "XMLParser") XMLParser XMLParser,
            LensService lensService,
            CameraService cameraService,
            PhotographerService photographerService) {
        this.consoleIO = consoleIO;
        this.fileIO = fileIO;
        this.JSONParser = JSONParser;
        this.XMLParser = XMLParser;
        this.lensService = lensService;
        this.cameraService = cameraService;
        this.photographerService = photographerService;
    }

    @Override
    public void run(String... strings) throws Exception {

        System.out.println("*** LIVE *** LIVE ** LIVE ***");
        System.out.println("*** LIVE *** LIVE ** LIVE ***");
        System.out.println("*** LIVE *** LIVE ** LIVE ***");

        importLenses();
        importCameras();
        importPhotographers();
        
    }

    private void importLenses() {
        LensDto[] lensDtos = null;
        try {
            lensDtos = this.JSONParser.read(LensDto[].class, "/files/json/input/lenses.json");
        } catch (JAXBException | IOException e) {
            e.printStackTrace();
        }

        for (LensDto lensDto : lensDtos) {
            try {
                this.lensService.create(lensDto);
                this.consoleIO.write(String.format("Successfully imported %s %smm f%s",
                        lensDto.getMake(), lensDto.getFocalLength(), lensDto.getMaxAperture()));
            } catch (Exception e) {
                this.consoleIO.write("Invalid Lens");
            }
        }
    }

    private void importCameras() {
        CameraDto[] cameraDtos = null;
        try {
            cameraDtos = this.JSONParser.read(CameraDto[].class, "/files/json/input/cameras.json");
        } catch (JAXBException | IOException e) {
            e.printStackTrace();
        }

        for (CameraDto cameraDto : cameraDtos) {
            try {
                this.cameraService.create(cameraDto);
                this.consoleIO.write(String.format("Successfully imported %s %s %s",
                        cameraDto.getType(), cameraDto.getMake(), cameraDto.getModel()));
            } catch (Exception e) {
                this.consoleIO.write("Invalid Camera");
            }
        }
    }

    private void importPhotographers() {
        PhotographerDto[] photographerDtos = null;
        try {
            photographerDtos = this.JSONParser.read(PhotographerDto[].class, "/files/json/input/photographers.json");
        } catch (JAXBException | IOException e) {
            e.printStackTrace();
        }

        for (PhotographerDto photographerDto : photographerDtos) {
            try {
                int lensesCount = this.photographerService.create(photographerDto);
                this.consoleIO.write(String.format("Successfully imported %s %s | Lenses: %s",
                        photographerDto.getFirstName(), photographerDto.getLastName(), lensesCount));
            } catch (Exception e) {
                this.consoleIO.write("Invalid Photographer");
            }
        }
    }
}
