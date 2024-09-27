package ufape.es.inventory.controllers.dto.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.modelmapper.ModelMapper;
import ufape.es.inventory.config.SpringApplicationContext;
import ufape.es.inventory.model.Warehouse;

@Data
public class WarehouseRequest {
    private Long id;
    @NotBlank(message = "Name cannot be blank when creating a warehouse.")
    private String name;
    @NotBlank(message = "Location cannot be blank when creating a warehouse.")
    private AddressRequest address;
    private String description;
    @NotNull(message = "Capacity cannot be null when creating a warehouse.")
    private Long capacity;

    public Warehouse convertToEntity() {
        ModelMapper modelMapper = (ModelMapper) SpringApplicationContext.getBean("modelMapper");
        Warehouse warehouse = modelMapper.map(this, Warehouse.class);
        return warehouse;
    }
}

