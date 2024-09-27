package ufape.es.inventory.controllers;

import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import ufape.es.inventory.controllers.dto.responses.WarehouseResponse;
import ufape.es.inventory.controllers.dto.requests.WarehouseRequest;
import ufape.es.inventory.facade.Facade;
import ufape.es.inventory.model.Warehouse;

import java.util.List;

@RestController
@RequestMapping("/inventory")
public class WarehouseController {

    @Autowired
    private Facade facade;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("/warehouse")
    public Warehouse createWarehouse(@Valid @RequestBody WarehouseRequest newObj) {
        return facade.createWarehouse(newObj.convertToEntity());
    }

    @PutMapping("/warehouse/{id}")
    public WarehouseResponse updateWarehouse(@PathVariable Long id, @Valid @RequestBody WarehouseRequest obj) {
        Warehouse oldObject = facade.getWarehouse(id);

        modelMapper.map(obj, oldObject);

        return new WarehouseResponse(facade.updateWarehouse(oldObject));
    }

    @GetMapping("/warehouse")
    public List<WarehouseResponse> getAllWarehouses() {
        return facade.getAllWarehouses()
                .stream()
                .map(WarehouseResponse::new)
                .toList();
    }

    @GetMapping("/warehouse/{id}")
    public WarehouseResponse getWarehouseById(@PathVariable long id) {
        return new WarehouseResponse(facade.getWarehouse(id));
    }

    @DeleteMapping("/warehouse/{id}")
    public void deleteWarehouse(@PathVariable long id) {
        facade.deleteWarehouse(id);
    }
}