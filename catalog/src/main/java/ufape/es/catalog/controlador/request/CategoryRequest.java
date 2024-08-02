package ufape.es.catalog.controlador.request;

import org.modelmapper.ModelMapper;
import ufape.es.catalog.model.Category;
import ufape.es.catalog.config.SpringApplicationContext;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CategoryRequest {
    @NotBlank(message = "The category name is required")
    private String name;
    private String description;
    private String icon;

    // private long parentCategory;

    public Category convertToBasicClass() {
        ModelMapper modelMapper = (ModelMapper) SpringApplicationContext.getBean("modelMapper");
        Category category = modelMapper.map(this, Category.class);
        return category;
    }
}
