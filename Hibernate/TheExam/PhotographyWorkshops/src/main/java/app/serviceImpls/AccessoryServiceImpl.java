package app.serviceImpls;

import app.domains.dtos.xmls.inputs.AccessoryDto;
import app.domains.entities.Accessory;
import app.domains.entities.Photographer;
import app.parsers.interfaces.ModelParser;
import app.repositories.AccessoryRepository;
import app.repositories.PhotographerRepository;
import app.services.AccessoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.ThreadLocalRandom;

@Service
public class AccessoryServiceImpl implements AccessoryService {

    private final ModelParser modelParser;

    private final AccessoryRepository accessoryRepository;

    private final PhotographerRepository photographerRepository;

    @Autowired
    public AccessoryServiceImpl(ModelParser modelParser, AccessoryRepository accessoryRepository, PhotographerRepository photographerRepository) {
        this.modelParser = modelParser;
        this.accessoryRepository = accessoryRepository;
        this.photographerRepository = photographerRepository;
    }

    @Override
    public void create(AccessoryDto accessoryDto) {
        Accessory accessory = this.modelParser.convert(accessoryDto, Accessory.class);
        Photographer photographer = this.getRandomPhotographer();
        accessory.setOwner(photographer);

        this.accessoryRepository.saveAndFlush(accessory);
    }

    private Photographer getRandomPhotographer() {
        Long photographerCount = this.photographerRepository.count();
        Long randomId = ThreadLocalRandom.current().nextLong(1, photographerCount + 1);
        return this.photographerRepository.findOne(randomId);
    }
}
