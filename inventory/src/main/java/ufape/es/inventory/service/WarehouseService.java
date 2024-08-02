

@service
public class WarehouseService {
    private WarehouseRepository warehouseRepository;
    private SectionRepository sectionRepository;
    private InventoryRepository inventoryRepository;

    public WarehouseService(WarehouseRepository warehouseRepository, SectionRepository sectionRepository, InventoryRepository inventoryRepository) {
        this.warehouseRepository = warehouseRepository;
        this.sectionRepository = sectionRepository;
        this.inventoryRepository = inventoryRepository;
    }

    public Warehouse createWarehouse(Warehouse warehouse) {
        return warehouseRepository.save(warehouse);
    }

    public Warehouse getWarehouse(Long id) {
        return warehouseRepository.findById(id).orElse(null);
    }

    public List<Warehouse> getWarehouses() {
        return warehouseRepository.findAll();
    }

    public Warehouse updateWarehouse(Long id, Warehouse warehouse) {
        Warehouse warehouseToUpdate = warehouseRepository.findById(id).orElse(null);
        if (warehouseToUpdate == null) {
            return null;
        }
        warehouseToUpdate.setName(warehouse.getName());
        warehouseToUpdate.setLocation(warehouse.getLocation());
        warehouseToUpdate.setDescription(warehouse.getDescription());
        warehouseToUpdate.setCapacity(warehouse.getCapacity());
        return warehouseRepository.save(warehouseToUpdate);
    }

    public void deleteWarehouse(Long id) {
        warehouseRepository.deleteById(id);
    }

    public Section createSection(Long warehouseId, Section section) {
        Warehouse warehouse = warehouseRepository.findById(warehouseId).orElse(null);
        if (warehouse == null) {
            return null;
        }
        section.setWarehouse(warehouse);
        return sectionRepository.save(section);
    }

    public Section getSection(Long id) {
        return sectionRepository.findById(id).orElse(null);
    }

    public List<Section> getSections() {
        return sectionRepository.findAll();
    }

    public Section updateSection(Long id, Section section) {
        Section sectionToUpdate = sectionRepository.findById(id).orElse(null);
        if (sectionToUpdate == null) {
            return null;
        }
        sectionToUpdate.setName(section.getName());
        sectionToUpdate.setDescription(section.getDescription());
        return sectionRepository.save(sectionToUpdate);
    }

    public void deleteSection(Long id) {
        sectionRepository.deleteById(id);
    }

    public Inventory createInventory(Long sectionId, Inventory inventory) {
        Section section = sectionRepository.findById(sectionId).orElse(null);
        if (section == null) {
            return null;
        }
        inventory.setSection(section);
        return inventoryRepository.save(inventory);
    }

    public Inventory getInventory(Long id) {
        return inventoryRepository.findById(id).orElse(null);
    }

    public List<Inventory> getInventories() {
}
