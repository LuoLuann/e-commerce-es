package ufape.es.core.dto;

public class InventoryDTO {
    private Long id;
    private Long productId;
    private Long warehouseId;
    private Long sectionId;
    private Long quantity;
    private Long maximumProducts;
    private Long minimumProducts;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(Long warehouseId) {
        this.warehouseId = warehouseId;
    }

    public Long getSectionId() {
        return sectionId;
    }

    public void setSectionId(Long sectionId) {
        this.sectionId = sectionId;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public Long getMaximumProducts() {
        return maximumProducts;
    }

    public void setMaximumProducts(Long maximumProducts) {
        this.maximumProducts = maximumProducts;
    }

    public Long getMinimumProducts() {
        return minimumProducts;
    }

    public void setMinimumProducts(Long minimumProducts) {
        this.minimumProducts = minimumProducts;
    }
}
