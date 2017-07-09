package app.services;

import app.domains.dtos.jsons.inputs.CameraDto;

public interface CameraService {

    void create(CameraDto cameraDto);
}
