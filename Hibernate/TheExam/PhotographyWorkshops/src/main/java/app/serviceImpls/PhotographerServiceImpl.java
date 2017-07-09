package app.serviceImpls;

import app.domains.dtos.jsons.inputs.PhotographerDto;
import app.domains.entities.Lens;
import app.domains.entities.Photographer;
import app.domains.entities.cameras.AbstractCamera;
import app.parsers.interfaces.ModelParser;
import app.repositories.CameraRepository;
import app.repositories.LensRepository;
import app.repositories.PhotographerRepository;
import app.services.PhotographerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

@Service
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

        int count = 0;
        Set<Integer> lenses = photographerDto.getLenses();
        for (Integer lensId : lenses) {
            Lens lens = this.lensRepository.findOne((long) lensId);
            if (lens == null) {
                continue;
            }

            if (!lens.getCompatibleMake().equals(primaryCamera.getMake()) &&
                    !lens.getCompatibleMake().equals(secondaryCamera.getMake())) {
                continue;
            }

            lens.setOwner(photographer);
            lensRepository.saveAndFlush(lens);
            count++;
        }

        return count;
    }


    private AbstractCamera getRandomCamera(){
        long cameraCount = this.cameraRepository.count();
        long randomId = ThreadLocalRandom.current().nextLong(1, cameraCount + 1);
        return this.cameraRepository.findOne(randomId);
    }
}
