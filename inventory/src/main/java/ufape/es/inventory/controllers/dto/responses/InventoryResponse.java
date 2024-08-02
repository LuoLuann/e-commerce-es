package ufape.es.inventory.controllers.dto.responses;

import lombok.Data;
import org.modelmapper.ModelMapper;
import ufape.es.inventory.config.SpringApplicationContext;
import ufape.es.inventory.model.Inventory;

@Data
public class InventoryResponse {

    private Long id;
    private Long productId;
    private Long quantity;
    private Long maximumProducts;
    private Long minimumProducts;
    private Long warehouseId;
    private Long sectionId;

    public InventoryResponse(Inventory inventory) {
        ModelMapper modelMapper = (ModelMapper) SpringApplicationContext.getBean("modelMapper");
        modelMapper.map(inventory, this);
    }
}

