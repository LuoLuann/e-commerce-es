package ufape.es.inventory.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ufape.es.inventory.model.Warehouse;
import ufape.es.inventory.repository.WarehouseRepository;
import ufape.es.inventory.service.interfaces.IWarehouse;

@Service
public class WarehouseService implements IWarehouse {
	
	@Autowired
    private WarehouseRepository warehouseRepository;

    @Override
    public Warehouse createWarehouse(Warehouse warehouse) {
        return warehouseRepository.save(warehouse);
    }

    @Override
    public Warehouse getWarehouse(Long id) {
        return warehouseRepository.findById(id).orElse(null);
    }

    @Override
    public List<Warehouse> getWarehouses() {
        return warehouseRepository.findAll();
    }

    @Override
    public Warehouse updateWarehouse(Long id, Warehouse warehouse) {
        Warehouse warehouseToUpdate = warehouseRepository.findById(id).orElse(null);
        if (warehouseToUpdate == null) {
            return null;
        }
        warehouseToUpdate.setName(warehouse.getName());
        warehouseToUpdate.setLocation(warehouse.getLocation());
        warehouseToUpdate.setDescription(warehouse.getDescription());
        warehouseToUpdate.setCapacity(warehouse.getCapacity());
        return warehouseRepository.save(warehouseToUpdate);
    }

    @Override
    public void deleteWarehouse(Long id) {
        warehouseRepository.deleteById(id);
    }
}
