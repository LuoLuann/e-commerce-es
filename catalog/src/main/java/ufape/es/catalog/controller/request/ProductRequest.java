package ufape.es.catalog.controller.request;

import org.modelmapper.ModelMapper;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import ufape.es.catalog.config.SpringApplicationContext;
import ufape.es.catalog.model.Product;

@Getter @Setter
public class ProductRequest {
    private String description;
    private String image;
    @NotNull(message = "Name cannot be null when creating a policy.")
    private String name;
    @NotNull(message = "Category ID cannot be null when creating an inventory.")
    private Long categoryId;

    private long parentCategoryId;

    public Product convertToEntity() {
        ModelMapper modelMapper = (ModelMapper) SpringApplicationContext.getBean("modelMapper");
        Product product = modelMapper.map(this, Product.class);
        return product;
    }
}
