package massdefect.serviceImpls;

import massdefect.domains.dtos.json.PlanetExportJSONDto;
import massdefect.domains.dtos.json.PlanetImportJSONDto;
import massdefect.domains.entities.Planet;
import massdefect.domains.entities.SolarSystem;
import massdefect.domains.entities.Star;
import massdefect.parsers.interfaces.ModelParser;
import massdefect.repositories.PlanetRepository;
import massdefect.repositories.SolarSystemRepository;
import massdefect.repositories.StarRepository;
import massdefect.serivces.PlanetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlanetServiceImpl implements PlanetService {

    private final PlanetRepository planetRepository;

    private final ModelParser modelParser;

    private final SolarSystemRepository solarSystemRepository;

    private final StarRepository starRepository;

    @Autowired
    public PlanetServiceImpl(PlanetRepository planetRepository, ModelParser modelParser, SolarSystemRepository solarSystemRepository, StarRepository starRepository) {
        this.planetRepository = planetRepository;
        this.modelParser = modelParser;
        this.solarSystemRepository = solarSystemRepository;
        this.starRepository = starRepository;
    }

    @Override
    public void create(PlanetImportJSONDto planetDto) {
        Planet planet = this.modelParser.convert(planetDto, Planet.class);
        SolarSystem solarSystem = this.solarSystemRepository.findByName(planetDto.getSolarSystemName());
        Star star = this.starRepository.findByName(planetDto.getSunName());

        planet.setSolarSystem(solarSystem);
        planet.setSun(star);

        this.planetRepository.saveAndFlush(planet);
    }

    @Override
    public List<PlanetExportJSONDto> allNonOriginPlanets() {
        List<Planet> planets = this.planetRepository.allNonOriginPlanets();
        List<PlanetExportJSONDto> planetExportJSONDtos = new ArrayList<>();

        for (Planet planet : planets) {
            PlanetExportJSONDto convert = this.modelParser.convert(planet, PlanetExportJSONDto.class);
            planetExportJSONDtos.add(convert);
        }

        return planetExportJSONDtos;
    }
}
