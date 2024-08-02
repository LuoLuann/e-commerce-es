package ufape.es.price.controller.dto.response;

import lombok.Data;
import org.modelmapper.ModelMapper;
import ufape.es.price.config.SpringApplicationContext;
import ufape.es.price.model.Policy;

@Data
public class PolicyResponse {
    private String description;
    private String type;
    private String name;
    private Boolean isActive;
    private Double discountPercentage;

    public PolicyResponse(Policy obj) {
        ModelMapper modelMapper = (ModelMapper) SpringApplicationContext.getBean("modelMapper");
        modelMapper.map(obj, this);
    }
}
