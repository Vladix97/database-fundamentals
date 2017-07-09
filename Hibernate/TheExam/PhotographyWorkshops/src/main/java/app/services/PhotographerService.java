package app.services;

import app.domains.dtos.jsons.inputs.PhotographerDto;

public interface PhotographerService {

    int create(PhotographerDto photographerDto);
}
