package massdefect.serivces;

import massdefect.domains.dtos.json.SolarSystemImportJSONDto;

public interface SolarSystemService {

    void create(SolarSystemImportJSONDto solarSystemImportDto);
}
