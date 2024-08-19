package ufape.es.catalog.controller.response;

import org.modelmapper.ModelMapper;

import lombok.Getter;
import lombok.Setter;
import ufape.es.catalog.config.SpringApplicationContext;
import ufape.es.catalog.model.Category;

@Getter @Setter
public class CategoryResponse {
    private long id;
    private String name;
    private String description;
    private String icon;
    private long parentCategoryId;

    public CategoryResponse(Category category) {
        ModelMapper modelMapper = (ModelMapper) SpringApplicationContext.getBean("modelMapper");
        modelMapper.map(category, this);
    }
}
