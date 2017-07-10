package app.services;

import app.domains.dtos.jsons.inputs.PhotographerDto;
import app.domains.dtos.jsons.outputs.LandscapePhotographersExportDto;
import app.domains.dtos.jsons.outputs.OrderedPhotographersExportDto;
import app.domains.dtos.xmls.outputs.PhotographerWithSameCamerasCollectionDto;
import app.domains.dtos.xmls.outputs.PhotographerWithSameCamerasDto;
import app.domains.entities.Photographer;

import java.util.List;

public interface PhotographerService {

    int create(PhotographerDto photographerDto);

    List<OrderedPhotographersExportDto> findAllByFirstNameAscLastNameDsc();

    List<LandscapePhotographersExportDto> findAllLandscapePhotographers();

    PhotographerWithSameCamerasCollectionDto findAllWithSameCameras();
}
