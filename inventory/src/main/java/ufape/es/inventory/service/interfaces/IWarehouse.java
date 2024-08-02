package ufape.es.inventory.service.interfaces;

import java.util.List;

import ufape.es.inventory.model.Warehouse;

public interface IWarehouse {
    Warehouse createWarehouse(Warehouse warehouse);
    Warehouse getWarehouse(Long id);
    List<Warehouse> getWarehouses();
    Warehouse updateWarehouse(Long id, Warehouse warehouse);
    void deleteWarehouse(Long id);
}
