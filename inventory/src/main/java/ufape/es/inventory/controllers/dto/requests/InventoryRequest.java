package ufape.es.inventory.controllers.dto.requests;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.modelmapper.ModelMapper;
import ufape.es.inventory.config.SpringApplicationContext;
import ufape.es.inventory.model.Inventory;

@Data
public class InventoryRequest {

    @NotNull(message = "Product ID cannot be null when creating an inventory.")
    private Long productId;

    @NotNull(message = "Quantity cannot be null when creating an inventory.")
    private Long quantity;

    private Long maximumProducts;
    private Long minimumProducts;

    @NotNull(message = "Warehouse ID cannot be null when creating an inventory.")
    private Long warehouseId;

    @NotNull(message = "Section ID cannot be null when creating an inventory.")
    private Long sectionId;

    public Inventory convertToEntity() {
        ModelMapper modelMapper = (ModelMapper) SpringApplicationContext.getBean("modelMapper");
        Inventory inventory = modelMapper.map(this, Inventory.class);
        return inventory;
    }
}

