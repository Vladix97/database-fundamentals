package app.serviceImpls;

import app.domains.dtos.jsons.inputs.PhotographerDto;
import app.domains.dtos.jsons.outputs.LandscapePhotographersExportDto;
import app.domains.dtos.jsons.outputs.OrderedPhotographersExportDto;
import app.domains.dtos.xmls.outputs.PhotographerWithSameCamerasCollectionDto;
import app.domains.dtos.xmls.outputs.PhotographerWithSameCamerasDto;
import app.domains.entities.Lens;
import app.domains.entities.Photographer;
import app.domains.entities.cameras.AbstractCamera;
import app.domains.entities.cameras.DSLRCamera;
import app.parsers.interfaces.ModelParser;
import app.repositories.CameraRepository;
import app.repositories.LensRepository;
import app.repositories.PhotographerRepository;
import app.services.PhotographerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

@Service
@Transactional
public class PhotographerServiceImpl implements PhotographerService {

    private final ModelParser modelParser;

    private final PhotographerRepository photographerRepository;

    private final CameraRepository cameraRepository;

    private final LensRepository lensRepository;

    @Autowired
    public PhotographerServiceImpl(ModelParser modelParser, PhotographerRepository photographerRepository, LensRepository lensRepository, CameraRepository cameraRepository) {
        this.modelParser = modelParser;
        this.photographerRepository = photographerRepository;
        this.cameraRepository = cameraRepository;
        this.lensRepository = lensRepository;
    }

    @Override
    public int create(PhotographerDto photographerDto) {
        Photographer photographer = this.modelParser.convert(photographerDto, Photographer.class);
        AbstractCamera primaryCamera = this.getRandomCamera();
        AbstractCamera secondaryCamera = this.getRandomCamera();

        photographer.setPrimaryCamera(primaryCamera);
        photographer.setSecondaryCamera(secondaryCamera);

        this.photographerRepository.saveAndFlush(photographer);
        int count = 0;
        Set<Long> lenses = photographerDto.getLenses();
        for (Long lensId : lenses) {
            Lens lens = this.lensRepository.findOne(lensId);
            if (lens == null) {
                continue;
            }

            if (!lens.getCompatibleMake().equals(primaryCamera.getMake()) &&
                    !lens.getCompatibleMake().equals(secondaryCamera.getMake())) {
                continue;
            }

            lens.setOwner(photographer);
            this.lensRepository.saveAndFlush(lens);
            count++;
        }

        return count;
    }

    @Override
    public List<OrderedPhotographersExportDto> findAllByFirstNameAscLastNameDsc() {
        List<Photographer> photographers = this.photographerRepository.findAllByFirstNameAscLastNameDsc();

        List<OrderedPhotographersExportDto> photographerExportDtos = new ArrayList<>();
        for (Photographer photographer : photographers) {
            OrderedPhotographersExportDto dto = this.modelParser.convert(photographer, OrderedPhotographersExportDto.class);
            photographerExportDtos.add(dto);
        }

        return photographerExportDtos;
    }

    @Override
    public List<LandscapePhotographersExportDto> findAllLandscapePhotographers() {
        List<Photographer> allWithLenses = this.photographerRepository.findAllWithLenses();
        List<LandscapePhotographersExportDto> landscapePhotographersExportDtos = new ArrayList<>();

        for (Photographer allWithLens : allWithLenses) {
            if (allWithLens.getPrimaryCamera() instanceof DSLRCamera) {
                LandscapePhotographersExportDto dto =
                        this.modelParser.convert(allWithLens, LandscapePhotographersExportDto.class);
                landscapePhotographersExportDtos.add(dto);
                dto.setCount(allWithLens.getLenses().size());
            }
        }

        return landscapePhotographersExportDtos;
    }

    @Override
    public PhotographerWithSameCamerasCollectionDto findAllWithSameCameras() {
        List<Photographer> photographers = this.photographerRepository.findAllWithSameCameras();
        Set<PhotographerWithSameCamerasDto> photographerCameraExportXMLs = new HashSet<>();
        for (Photographer photographer : photographers) {
            PhotographerWithSameCamerasDto dto =
                    this.modelParser.convert(photographer, PhotographerWithSameCamerasDto.class);
            photographerCameraExportXMLs.add(dto);
        }

        PhotographerWithSameCamerasCollectionDto photographersCameraExportXML =
                new PhotographerWithSameCamerasCollectionDto();
        photographersCameraExportXML.setPhotographerWithSameCamerasDtos(photographerCameraExportXMLs);
        return photographersCameraExportXML;
    }

    private AbstractCamera getRandomCamera() {
        Long cameraCount = this.cameraRepository.count();
        Long randomId = ThreadLocalRandom.current().nextLong(1, cameraCount + 1);
        return this.cameraRepository.findOne(randomId);
    }
}
