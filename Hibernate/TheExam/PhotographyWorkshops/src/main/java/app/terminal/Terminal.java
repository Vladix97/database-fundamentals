package app.terminal;

import app.domains.dtos.jsons.inputs.CameraDto;
import app.domains.dtos.jsons.inputs.LensDto;
import app.domains.dtos.jsons.inputs.PhotographerDto;
import app.domains.dtos.jsons.outputs.LandscapePhotographersExportDto;
import app.domains.dtos.jsons.outputs.OrderedPhotographersExportDto;
import app.domains.dtos.xmls.inputs.AccessoryCollectionDto;
import app.domains.dtos.xmls.inputs.AccessoryDto;
import app.domains.dtos.xmls.inputs.WorkshopCollectionDto;
import app.domains.dtos.xmls.inputs.WorkshopDto;
import app.domains.dtos.xmls.outputs.PhotographerWithSameCamerasCollectionDto;
import app.domains.entities.Photographer;
import app.ios.interfaces.ConsoleIO;
import app.ios.interfaces.FileIO;
import app.parsers.XMLParser;
import app.parsers.interfaces.FileParser;
import app.services.*;
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

    private final FileParser JSONParser;

    private final XMLParser XMLParser;

    private final LensService lensService;

    private final CameraService cameraService;

    private final PhotographerService photographerService;

    private final AccessoryService accessoryService;

    private final WorkshopService workshopService;

    @Autowired
    public Terminal(
            ConsoleIO consoleIO,
            FileIO fileIO,
            @Qualifier(value = "JSONParser") FileParser JSONParser,
            @Qualifier(value = "XMLParser") XMLParser XMLParser,
            LensService lensService,
            CameraService cameraService,
            PhotographerService photographerService,
            AccessoryService accessoryService,
            WorkshopService workshopService) {
        this.consoleIO = consoleIO;
        this.fileIO = fileIO;
        this.JSONParser = JSONParser;
        this.XMLParser = XMLParser;
        this.lensService = lensService;
        this.cameraService = cameraService;
        this.photographerService = photographerService;
        this.accessoryService = accessoryService;
        this.workshopService = workshopService;
    }

    @Override
    public void run(String... strings) throws Exception {

        System.out.println("*** LIVE *** LIVE ** LIVE ***");
        System.out.println("*** LIVE *** LIVE ** LIVE ***");
        System.out.println("*** LIVE *** LIVE ** LIVE ***");

        // IMPORTS
//        importLenses();
//        importCameras();
//        importPhotographers();
//        importAccessories();
//        importWorkshops();

        // EXPORTS
        exportOrderedPhotographers();
        exportLandscapePhotographers();
        exportSameCamerasPhotographers();

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

    private void importAccessories() {
        AccessoryCollectionDto accessoryCollectionDto = null;
        try {
            accessoryCollectionDto = this.XMLParser.read(AccessoryCollectionDto.class, "/files/xml/input/accessories.xml");
        } catch (JAXBException | IOException e) {
            e.printStackTrace();
        }

        Set<AccessoryDto> accessoryDtos = accessoryCollectionDto.getAccessoryDtos();
        for (AccessoryDto accessoryDto : accessoryDtos) {
            try {
                this.accessoryService.create(accessoryDto);
                this.consoleIO.write(String.format("Successfully imported %s", accessoryDto.getName()));
            } catch (Exception e) {
                this.consoleIO.write("Invalid Accessory");
            }
        }
    }

    private void importWorkshops() {
        WorkshopCollectionDto workshopCollectionDto = null;
        try {
            workshopCollectionDto = this.XMLParser.read(WorkshopCollectionDto.class, "/files/xml/input/workshops.xml");
        } catch (JAXBException | IOException e) {
            e.printStackTrace();
        }

        Set<WorkshopDto> workshopDtos = workshopCollectionDto.getWorkshopDtos();
        for (WorkshopDto workshopDto : workshopDtos) {
            try {
                this.workshopService.create(workshopDto);
                this.consoleIO.write(String.format("Successfully imported %s", workshopDto.getName()));
            } catch (Exception e) {
                this.consoleIO.write("Invalid Workshop");
            }
        }
    }

    private void exportOrderedPhotographers() {
        List<OrderedPhotographersExportDto> allByFirstNameAscLastNameDsc =
                this.photographerService.findAllByFirstNameAscLastNameDsc();

        try {
            this.JSONParser.write(allByFirstNameAscLastNameDsc, "src/main/resources/files/json/output/photographers-ordered.json");
        } catch (JAXBException | IOException e) {
            e.printStackTrace();
        }
    }

    private void exportLandscapePhotographers() {
        List<LandscapePhotographersExportDto> allLandscapePhotographers =
                this.photographerService.findAllLandscapePhotographers();

        try {
            this.JSONParser.write(allLandscapePhotographers, "src/main/resources/files/json/output/landscape-photographers.json");
        } catch (JAXBException | IOException e) {
            e.printStackTrace();
        }
    }

    private void exportSameCamerasPhotographers() {
        PhotographerWithSameCamerasCollectionDto allWithSameCameras =
                this.photographerService.findAllWithSameCameras();

        try {
            this.XMLParser.write(allWithSameCameras, "src/main/resources/files/xml/output/same-cameras-photographers.xml");
        } catch (JAXBException | IOException e) {
            e.printStackTrace();
        }
    }
}
