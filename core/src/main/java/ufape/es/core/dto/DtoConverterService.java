package ufape.es.core.dto;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class DtoConverterService {
    private final ModelMapper modelMapper;

    public DtoConverterService(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public <D, T> D convertToDto(T entity, Class<D> dtoClass) {
        return modelMapper.map(entity, dtoClass);
    }

    public <D, T> T convertToEntity(D dto, Class<T> entityClass) {
        return modelMapper.map(dto, entityClass);
    }
}
