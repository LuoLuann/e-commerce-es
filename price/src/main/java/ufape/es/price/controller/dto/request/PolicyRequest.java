package ufape.es.price.controller.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.modelmapper.ModelMapper;
import ufape.es.price.config.SpringApplicationContext;
import ufape.es.price.model.Policy;

@Data
public class PolicyRequest {
    private String description;
    @NotNull(message = "Type cannot be null when creating a policy.")
    private String type;
    @NotNull(message = "Name cannot be null when creating a policy.")
    private String name;
    private Boolean isActive = false;
    private Double discountPercentage;

    public Policy convertToEntity() {
        ModelMapper modelMapper = (ModelMapper) SpringApplicationContext.getBean("modelMapper");
        Policy obj = modelMapper.map(this, Policy.class);
        return obj;
    }
}
