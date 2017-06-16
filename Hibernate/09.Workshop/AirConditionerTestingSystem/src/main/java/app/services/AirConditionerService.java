package app.services;

import app.domains.dtos.AirConditionerDto;

public interface AirConditionerService {

    public <D> void persist(AirConditionerDto abstractAirConditionerDto, Class<D> destination);
}
