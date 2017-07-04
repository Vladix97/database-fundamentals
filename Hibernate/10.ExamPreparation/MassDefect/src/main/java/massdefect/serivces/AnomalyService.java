package massdefect.serivces;

import massdefect.domains.dtos.json.AnomalyExportJSONDto;
import massdefect.domains.dtos.json.AnomalyImportJSONDto;
import massdefect.domains.dtos.json.AnomalyVictimImportJSONDto;
import massdefect.domains.dtos.xml.AnomalyCollectionXMLDto;
import massdefect.domains.dtos.xml.AnomalyXMLDto;

public interface AnomalyService {

    void create(AnomalyImportJSONDto anomalyImportDto);

    void create(AnomalyVictimImportJSONDto anomalyVictimImportDto);

    void create(AnomalyXMLDto anomalyVictimImportXMLDto);

    AnomalyExportJSONDto anomalyWithMostVictims();

    AnomalyCollectionXMLDto findAllAnomalies();
}
