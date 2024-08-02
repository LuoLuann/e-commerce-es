package ufape.es.price.controller.dto.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import org.modelmapper.ModelMapper;
import ufape.es.price.config.SpringApplicationContext;
import ufape.es.price.model.Policy;

import java.math.BigDecimal;

@Data
public class PriceRequest {
    @NotNull(message = "Base price cannot be null when creating a price.")
    @Positive(message = "The base price cannot be negative.")
    private BigDecimal basePrice;
    private BigDecimal currentPrice;
    private String priceType;
    @NotNull(message = "Product ID cannot be null when creating a price.")
    private Long productId;

    public Policy convertToEntity() {
        ModelMapper modelMapper = (ModelMapper) SpringApplicationContext.getBean("modelMapper");
        Policy obj = modelMapper.map(this, Policy.class);
        return obj;
    }
}
