package massdefect.serivces;

import massdefect.domains.dtos.json.AnomalyExportJSONDto;
import massdefect.domains.dtos.json.AnomalyImportJSONDto;
import massdefect.domains.dtos.json.AnomalyVictimImportJSONDto;
import massdefect.domains.dtos.xml.AnomalyVictimImportXMLDto;

import java.util.List;

public interface AnomalyService {

    void create(AnomalyImportJSONDto anomalyImportDto);

    void create(AnomalyVictimImportJSONDto anomalyVictimImportDto);

    void create(AnomalyVictimImportXMLDto anomalyVictimImportXMLDto);

    AnomalyExportJSONDto anomalyWithMostVictims();
}
