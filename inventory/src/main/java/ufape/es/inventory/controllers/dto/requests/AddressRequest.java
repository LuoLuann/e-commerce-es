package ufape.es.inventory.controllers.dto.requests;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import ufape.es.inventory.config.SpringApplicationContext;
import ufape.es.inventory.model.Address;

@Data @AllArgsConstructor @NoArgsConstructor
public class AddressRequest {
    private Long id;
    private String street;
    private String city;
    private String state;
    private String country;
    private String zipCode;
    private String number;
    private String complement;
    private String neighborhood;
    private String reference;

    public Address convertToEntity() {
        ModelMapper modelMapper = (ModelMapper) SpringApplicationContext.getBean("modelMapper");
        Address obj = modelMapper.map(this, Address.class);
        return obj;
    }
}
