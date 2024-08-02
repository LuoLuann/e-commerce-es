package ufape.es.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ufape.es.inventory.model.Inventory;


public interface InventoryRepository extends JpaRepository<Inventory, Long> {
}
