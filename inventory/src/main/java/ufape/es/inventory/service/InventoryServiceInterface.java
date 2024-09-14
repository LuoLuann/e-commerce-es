package ufape.es.inventory.service;

import java.util.List;

import ufape.es.inventory.model.Inventory;

public interface InventoryServiceInterface {
    Inventory createInventory(Long sectionId, Inventory inventory);
    Inventory getInventory(Long id);
    List<Inventory> getInventories();
    Inventory updateInventory(Long id, Inventory inventory);
    void deleteInventory(Long id);
}

