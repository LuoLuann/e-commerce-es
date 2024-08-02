public class InventoryRepository implments JpaRepository<Inventory, Long> {
    public InventoryRepository() {
        super(Inventory.class);
    }
}
