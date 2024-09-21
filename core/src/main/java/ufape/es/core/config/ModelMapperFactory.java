package ufape.es.core.config;

import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;

public class ModelMapperFactory {

    public static ModelMapper createModelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setPropertyCondition(Conditions.isNotNull());
        return modelMapper;
    }
}

