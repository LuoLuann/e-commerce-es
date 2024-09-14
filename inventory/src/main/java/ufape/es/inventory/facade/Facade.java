package ufape.es.inventory.facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ufape.es.inventory.model.Warehouse;
import ufape.es.inventory.model.Section;
import ufape.es.inventory.model.Inventory;
import ufape.es.inventory.service.IInventoryService;
import ufape.es.inventory.service.ISectionService;
import ufape.es.inventory.service.IWarehouseService;

@Component
public class Facade {

    @Autowired
    private IWarehouseService warehouseService;

    @Autowired
    private ISectionService sectionService;

    @Autowired
    private IInventoryService inventoryService;

    // Methods to Warehouse
    public Warehouse createWarehouse(Warehouse warehouse) {
        return warehouseService.createWarehouse(warehouse);
    }

    public Warehouse getWarehouse(Long id) {
        return warehouseService.getWarehouse(id);
    }

    public List<Warehouse> getWarehouses() {
        return warehouseService.getWarehouses();
    }

    public Warehouse updateWarehouse(Long id, Warehouse warehouse) {
        return warehouseService.updateWarehouse(id, warehouse);
    }

    public void deleteWarehouse(Long id) {
        warehouseService.deleteWarehouse(id);
    }

    // Meyhods to Section
    public Section createSection(Long warehouseId, Section section) {
        return sectionService.createSection(warehouseId, section);
    }

    public Section getSection(Long id) {
        return sectionService.getSection(id);
    }

    public List<Section> getSections() {
        return sectionService.getSections();
    }

    public Section updateSection(Long id, Section section) {
        return sectionService.updateSection(id, section);
    }

    public void deleteSection(Long id) {
        sectionService.deleteSection(id);
    }

    // Methods for Inventory
    public Inventory createInventory(Long sectionId, Inventory inventory) {
        return inventoryService.createInventory(sectionId, inventory);
    }

    public Inventory getInventory(Long id) {
        return inventoryService.getInventory(id);
    }

    public List<Inventory> getInventories() {
        return inventoryService.getInventories();
    }

    public Inventory updateInventory(Long id, Inventory inventory) {
        return inventoryService.updateInventory(id, inventory);
    }

    public void deleteInventory(Long id) {
        inventoryService.deleteInventory(id);
    }
}