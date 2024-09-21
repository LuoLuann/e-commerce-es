package ufape.es.inventory.controllers;

import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ufape.es.inventory.controllers.dto.requests.InventoryRequest;
import ufape.es.inventory.controllers.dto.responses.InventoryResponse;
import ufape.es.inventory.facade.Facade;
import ufape.es.inventory.model.Inventory;

import java.util.List;

@RestController
public class InventoryController {

    @Autowired
    private Facade facade;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("/inventory")
    public Inventory createInventory(@Valid @RequestBody InventoryRequest newObj) {
        return facade.createInventory(newObj.convertToEntity());
    }

    @PutMapping("/inventory/{id}")
    public InventoryResponse updateInventory(@PathVariable Long id, @Valid @RequestBody InventoryRequest obj) {
        Inventory oldObject = facade.getInventory(id);

        modelMapper.map(obj, oldObject);

        return new InventoryResponse(facade.updateInventory(oldObject));
    }

    @GetMapping("/inventory")
    public List<InventoryResponse> getAllInventories() {
        return facade.getAllInventories()
                .stream()
                .map(InventoryResponse::new)
                .toList();
    }

    @GetMapping("/inventory/{id}")
    public InventoryResponse getInventoryById(@PathVariable long id) {
        return new InventoryResponse(facade.getInventory(id));
    }

    @DeleteMapping("/inventory/{id}")
    public void deleteInventory(@PathVariable long id) {
        facade.deleteInventory(id);
    }
}


