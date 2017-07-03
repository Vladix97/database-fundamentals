package massdefect.serviceImpls;

import massdefect.domains.dtos.json.StarImportJSONDto;
import massdefect.domains.entities.SolarSystem;
import massdefect.domains.entities.Star;
import massdefect.parsers.interfaces.ModelParser;
import massdefect.repositories.SolarSystemRepository;
import massdefect.repositories.StarRepository;
import massdefect.serivces.StarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StarServiceImpl implements StarService {

    private final StarRepository starRepository;

    private final SolarSystemRepository solarSystemRepository;

    private final ModelParser modelParser;

    @Autowired
    public StarServiceImpl(StarRepository starRepository, ModelParser modelParser, SolarSystemRepository solarSystemRepository) {
        this.starRepository = starRepository;
        this.modelParser = modelParser;
        this.solarSystemRepository = solarSystemRepository;
    }

    @Override
    public void create(StarImportJSONDto starImportDto) {
        Star star = this.modelParser.convert(starImportDto, Star.class);
        SolarSystem solarSystem = this.solarSystemRepository.findByName(starImportDto.getSolarSystemName());
        star.setSolarSystem(solarSystem);

        this.starRepository.saveAndFlush(star);
    }
}
