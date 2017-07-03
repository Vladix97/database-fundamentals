package massdefect.serivces;

import massdefect.domains.dtos.json.PersonExportJSONDto;
import massdefect.domains.dtos.json.PersonImportJSONDto;

import java.util.List;

public interface PersonService {

    void create(PersonImportJSONDto personImportDto);

    List<PersonExportJSONDto> nonVictims();
}
