package ufape.es.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ufape.es.inventory.model.Warehouse;

public interface WarehouseRepository extends JpaRepository<Warehouse, Long> {

    
}
