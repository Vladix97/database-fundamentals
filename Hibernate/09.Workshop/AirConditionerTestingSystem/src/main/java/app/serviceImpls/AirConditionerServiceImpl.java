package app.serviceImpls;

import app.controllers.AirConditionerRepository;
import app.domains.dtos.AirConditionerDto;
import app.parsers.ModelParser;
import app.services.AirConditionerService;
import org.springframework.stereotype.Service;

@Service
public class AirConditionerServiceImpl implements AirConditionerService {

    private final AirConditionerRepository abstractAirConditionerRepository;

    private final ModelParser modelParser;

    public AirConditionerServiceImpl(AirConditionerRepository abstractAirConditionerRepository, ModelParser modelParser) {
        this.abstractAirConditionerRepository = abstractAirConditionerRepository;
        this.modelParser = modelParser;
    }

    @Override
    public <D> void persist(AirConditionerDto abstractAirConditionerDto, Class<D> destination) {
        D entity = this.modelParser.convert(abstractAirConditionerDto, destination);

        this.abstractAirConditionerRepository.saveAndFlush(entity);
    }
}
