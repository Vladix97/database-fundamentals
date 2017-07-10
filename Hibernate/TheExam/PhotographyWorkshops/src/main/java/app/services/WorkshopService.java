package app.services;

import app.domains.dtos.xmls.inputs.WorkshopDto;

public interface WorkshopService {

    void create(WorkshopDto workshopDto);
}
