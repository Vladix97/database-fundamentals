package app.serviceImpls;

import app.domains.dtos.jsons.inputs.LensDto;
import app.domains.entities.Lens;
import app.parsers.interfaces.ModelParser;
import app.repositories.LensRepository;
import app.services.LensService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LensServiceImpl implements LensService {

    private final ModelParser modelParser;

    private final LensRepository lensRepository;

    @Autowired
    public LensServiceImpl(ModelParser modelParser, LensRepository lensRepository) {
        this.modelParser = modelParser;
        this.lensRepository = lensRepository;
    }

    @Override
    public void create(LensDto lensDto) {
        Lens lens = this.modelParser.convert(lensDto, Lens.class);
        this.lensRepository.saveAndFlush(lens);
    }
}
