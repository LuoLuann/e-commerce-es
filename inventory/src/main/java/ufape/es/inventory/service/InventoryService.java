package ufape.es.inventory.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ufape.es.inventory.model.Inventory;
import ufape.es.inventory.model.Section;
import ufape.es.inventory.repository.InventoryRepository;
import ufape.es.inventory.repository.SectionRepository;

@Service
public class InventoryService implements InventoryServiceInterface {

    @Autowired
    private InventoryRepository inventoryRepository;

    @Autowired
    private SectionRepository sectionRepository;

    @Override
    public Inventory createInventory(Long sectionId, Inventory inventory) {
        Section section = sectionRepository.findById(sectionId).orElse(null);
        if (section == null) {
            throw new IllegalArgumentException("Section not found");
        }
        inventory.setSection(section);
        return inventoryRepository.save(inventory);
    }

    @Override
    public Inventory getInventory(Long id) {
        return inventoryRepository.findById(id).orElse(null);
    }

    @Override
    public List<Inventory> getInventories() {
        return inventoryRepository.findAll();
    }

    @Override
    public Inventory updateInventory(Long id, Inventory inventory) {
        Inventory existingInventory = inventoryRepository.findById(id).orElse(null);
        if (existingInventory == null) {
            throw new IllegalArgumentException("Inventory not found");
        }
        existingInventory.setProductId(inventory.getProductId());
        existingInventory.setQuantity(inventory.getQuantity());
        existingInventory.setMaximumProducts(inventory.getMaximumProducts());
        existingInventory.setMinimumProducts(inventory.getMinimumProducts());
        existingInventory.setSection(inventory.getSection());
        existingInventory.setWarehouse(inventory.getWarehouse());
        return inventoryRepository.save(existingInventory);
    }

    @Override
    public void deleteInventory(Long id) {
        inventoryRepository.deleteById(id);
    }
}
