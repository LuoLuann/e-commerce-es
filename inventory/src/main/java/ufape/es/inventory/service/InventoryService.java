package ufape.es.inventory.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ufape.es.inventory.model.Inventory;
import ufape.es.inventory.repository.InventoryRepository;
import ufape.es.inventory.service.interfaces.IInventory;

@Service
public class InventoryService implements IInventory {

	   @Autowired
	    private InventoryRepository inventoryRepository;

	    @Override
	    public Inventory createInventory(Long sectionId, Inventory inventory) {
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

}