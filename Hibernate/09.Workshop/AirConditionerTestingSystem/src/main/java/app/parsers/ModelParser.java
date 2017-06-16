package app.parsers;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ModelParser {

    private ModelMapper modelMapper;

    public ModelParser() {
        this.modelMapper = new ModelMapper();
    }

    public <S, D> D convert(S source, Class<D> destination) {
        return this.modelMapper.map(source, destination);
    }
}
