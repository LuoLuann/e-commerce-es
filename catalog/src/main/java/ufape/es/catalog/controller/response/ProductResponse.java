package ufape.es.catalog.controller.response;

import org.modelmapper.ModelMapper;

import lombok.Getter;
import lombok.Setter;
import ufape.es.catalog.config.SpringApplicationContext;
import ufape.es.catalog.model.Product;

@Getter @Setter
public class ProductResponse {
    private long id;
    private String name;
    private String description;
    private String image;
    private long categoryId;
    
    public ProductResponse(Product product) {
        ModelMapper modelMapper = (ModelMapper) SpringApplicationContext.getBean("modelMapper");
        modelMapper.map(product, this);
    }
}
