package ufape.es.inventory.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ufape.es.inventory.model.Inventory;
import ufape.es.inventory.repository.InventoryRepository;
import ufape.es.inventory.service.exception.ObjectNotFoundException;

@Service
public class InventoryService implements InventoryServiceInterface {

    @Autowired
    private InventoryRepository inventoryRepository;

    @Override
    public Inventory createInventory(Inventory inventory) {
        return inventoryRepository.save(inventory);
    }

    @Override
    public Inventory getInventory(Long id) {
        return inventoryRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Inventory not found (id: " + id + ")"));
    }

    @Override
    public List<Inventory> getAllInventories() {
        return inventoryRepository.findAll();
    }

    @Override
    public Inventory updateInventory(Inventory inventory) {
        return inventoryRepository.save(inventory);
    }

    @Override
    public void deleteInventory(Long id) {
        inventoryRepository.deleteById(id);
    }
}
