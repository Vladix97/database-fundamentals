package app.serviceImpls;

import app.domains.dtos.jsons.inputs.CameraDto;
import app.domains.entities.cameras.AbstractCamera;
import app.domains.entities.cameras.DSLRCamera;
import app.domains.entities.cameras.MirrorlessCamera;
import app.parsers.interfaces.ModelParser;
import app.repositories.CameraRepository;
import app.services.CameraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CameraServiceImpl implements CameraService {

    private final ModelParser modelParser;

    private final CameraRepository cameraRepository;

    @Autowired
    public CameraServiceImpl(ModelParser modelParser, CameraRepository cameraRepository) {
        this.modelParser = modelParser;
        this.cameraRepository = cameraRepository;
    }


    @Override
    public void create(CameraDto cameraDto) {
        AbstractCamera camera = null;
        if (cameraDto.getType().equals("DSLR")) {
            camera = this.modelParser.convert(cameraDto, DSLRCamera.class);
        } else {
            camera = this.modelParser.convert(cameraDto, MirrorlessCamera.class);
        }

        this.cameraRepository.saveAndFlush(camera);
    }
}
