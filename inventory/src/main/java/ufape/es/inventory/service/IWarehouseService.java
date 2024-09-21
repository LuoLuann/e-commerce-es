package ufape.es.inventory.service;

import java.util.List;

import ufape.es.inventory.model.Warehouse;

public interface IWarehouseService {
    Warehouse createWarehouse(Warehouse warehouse);
    Warehouse getWarehouse(Long id);
    List<Warehouse> getAllWarehouses();
    Warehouse updateWarehouse(Warehouse warehouse);
    void deleteWarehouse(Long id);
}
