package ufape.es.inventory.service.interfaces;

import java.util.List;

import ufape.es.inventory.model.Inventory;

public interface IInventory {
    Inventory createInventory(Long sectionId, Inventory inventory);
    Inventory getInventory(Long id);
    List<Inventory> getInventories();
}

