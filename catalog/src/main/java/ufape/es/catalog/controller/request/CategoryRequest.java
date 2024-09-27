package ufape.es.catalog.controller.request;

import org.modelmapper.ModelMapper;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import ufape.es.catalog.config.SpringApplicationContext;
import ufape.es.catalog.model.Category;

@Getter @Setter
public class CategoryRequest {
    private Long id;
    @NotBlank(message = "The category name is required")
    private String name;
    private String description;
    private String icon;

    private long parentCategoryId;

    public Category convertToEntity() {
        ModelMapper modelMapper = (ModelMapper) SpringApplicationContext.getBean("modelMapper");
        Category category = modelMapper.map(this, Category.class);
        return category;
    }
}
