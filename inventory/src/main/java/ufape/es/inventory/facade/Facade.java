package ufape.es.inventory.facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ufape.es.inventory.model.*;
import ufape.es.inventory.service.*;

@Service
public class Facade {

    @Autowired
    private IWarehouseService warehouseService;

    @Autowired
    private ISectionService sectionService;

    @Autowired
    private InventoryServiceInterface inventoryService;

    // Methods to Warehouse
    public Warehouse createWarehouse(Warehouse warehouse) {
        return warehouseService.createWarehouse(warehouse);
    }

    public Warehouse getWarehouse(Long id) {
        return warehouseService.getWarehouse(id);
    }

    public List<Warehouse> getAllWarehouses() {
        return warehouseService.getAllWarehouses();
    }

    public Warehouse updateWarehouse(Warehouse warehouse) {
        return warehouseService.updateWarehouse(warehouse);
    }

    public void deleteWarehouse(Long id) {
        warehouseService.deleteWarehouse(id);
    }

    // Meyhods to Section
    public Section createSection(Section section) {
        return sectionService.createSection(section);
    }

    public Section getSection(Long id) {
        return sectionService.getSection(id);
    }

    public List<Section> getAllSections() {
        return sectionService.getAllSections();
    }

    public Section updateSection(Section section) {
        return sectionService.updateSection(section);
    }

    public void deleteSection(Long id) {
        sectionService.deleteSection(id);
    }

    // Methods for Inventory
    public Inventory createInventory(Inventory inventory) {
        return inventoryService.createInventory(inventory);
    }

    public Inventory getInventory(Long id) {
        return inventoryService.getInventory(id);
    }

    public List<Inventory> getAllInventories() {
        return inventoryService.getAllInventories();
    }

    public Inventory updateInventory(Inventory inventory) {
        return inventoryService.updateInventory(inventory);
    }

    public void deleteInventory(Long id) {
        inventoryService.deleteInventory(id);
    }
}