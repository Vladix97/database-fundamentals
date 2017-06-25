package massdefect.serviceImpls;

import massdefect.domains.dtos.json.SolarSystemImportDto;
import massdefect.domains.entities.SolarSystem;
import massdefect.parsers.interfaces.ModelParser;
import massdefect.repositories.SolarSystemRepository;
import massdefect.serivces.SolarSystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SolarSystemServiceImpl implements SolarSystemService {

    private final SolarSystemRepository solarSystemRepository;

    private final ModelParser modelParser;

    @Autowired
    public SolarSystemServiceImpl(SolarSystemRepository solarSystemRepository, ModelParser modelParser) {
        this.solarSystemRepository = solarSystemRepository;
        this.modelParser = modelParser;
    }

    @Override
    public void create(SolarSystemImportDto solarSystemImportDto) {
        SolarSystem solarSystem = this.modelParser.convert(solarSystemImportDto, SolarSystem.class);
        this.solarSystemRepository.saveAndFlush(solarSystem);
    }
}
