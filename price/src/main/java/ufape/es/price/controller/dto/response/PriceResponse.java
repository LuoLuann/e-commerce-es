package ufape.es.price.controller.dto.response;

import lombok.Data;
import org.modelmapper.ModelMapper;
import ufape.es.price.config.SpringApplicationContext;
import ufape.es.price.model.Policy;
import ufape.es.price.model.Price;

import java.math.BigDecimal;

@Data
public class PriceResponse {
    private Long productId;
    private BigDecimal basePrice;
    private BigDecimal currentPrice;
    private String priceType;

    public PriceResponse(Price obj) {
        ModelMapper modelMapper = (ModelMapper) SpringApplicationContext.getBean("modelMapper");
        modelMapper.map(obj, this);
    }
}
