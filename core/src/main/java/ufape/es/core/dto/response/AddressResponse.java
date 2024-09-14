package ufape.es.core.dto.response;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import ufape.es.core.config.SpringApplicationContext;
import ufape.es.core.model.Address;

@Data @AllArgsConstructor @NoArgsConstructor
public class AddressResponse {
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

    public AddressResponse(Address obj){
        ModelMapper modelMapper = (ModelMapper) SpringApplicationContext.getBean("modelMapper");
        modelMapper.map(obj, this);
    }
}
