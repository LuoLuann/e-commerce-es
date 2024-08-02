package ufape.es.inventory.controllers.dto.responses;

import lombok.Data;
import org.modelmapper.ModelMapper;
import ufape.es.inventory.config.SpringApplicationContext;
import ufape.es.inventory.model.Section;

@Data
public class SectionResponse {

    private Long id;
    private String name;
    private Long warehouseId;

    public SectionResponse(Section section) {
        ModelMapper modelMapper = (ModelMapper) SpringApplicationContext.getBean("modelMapper");
        modelMapper.map(section, this);
    }
}

