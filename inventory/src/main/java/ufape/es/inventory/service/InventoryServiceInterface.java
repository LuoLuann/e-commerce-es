package ufape.es.inventory.service;

import java.util.List;

import ufape.es.inventory.model.Inventory;

public interface InventoryServiceInterface {
    Inventory createInventory(Inventory inventory);
    Inventory getInventory(Long id);
    List<Inventory> getAllInventories();
    Inventory updateInventory(Inventory inventory);
    void deleteInventory(Long id);
}

