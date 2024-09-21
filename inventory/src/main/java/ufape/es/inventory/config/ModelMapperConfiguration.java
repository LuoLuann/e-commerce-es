package ufape.es.inventory.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import ufape.es.core.config.ModelMapperFactory;

@Configuration
public class ModelMapperConfiguration {

    @Bean
    public ModelMapper modelMapper() {
        return ModelMapperFactory.createModelMapper();
    }
}
