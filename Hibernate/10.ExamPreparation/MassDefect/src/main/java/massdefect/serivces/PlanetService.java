package massdefect.serivces;

import massdefect.domains.dtos.json.PlanetExportJSONDto;
import massdefect.domains.dtos.json.PlanetImportJSONDto;

import java.util.List;

public interface PlanetService {

    public void create(PlanetImportJSONDto planetDto);

    List<PlanetExportJSONDto> allNonOriginPlanets();
}
