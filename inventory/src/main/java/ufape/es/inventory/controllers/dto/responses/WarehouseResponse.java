package ufape.es.inventory.controllers.dto.responses;

import lombok.Data;
import org.modelmapper.ModelMapper;
import ufape.es.inventory.config.SpringApplicationContext;
import ufape.es.inventory.model.Warehouse;

@Data
public class WarehouseResponse {

    private Long id;
    private String name;
    private String location;
    private String description;
    private Long capacity;

    public WarehouseResponse(Warehouse warehouse) {
        ModelMapper modelMapper = (ModelMapper) SpringApplicationContext.getBean("modelMapper");
        modelMapper.map(warehouse, this);
    }
}

