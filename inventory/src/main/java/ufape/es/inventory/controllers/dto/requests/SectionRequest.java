package ufape.es.inventory.controllers.dto.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.modelmapper.ModelMapper;
import ufape.es.inventory.config.SpringApplicationContext;
import ufape.es.inventory.model.Section;

@Data
public class SectionRequest {

    @NotBlank(message = "Name cannot be blank when creating a section.")
    private String name;

    @NotNull(message = "Warehouse ID cannot be null when creating a section.")
    private Long warehouseId;

    public Section convertToEntity() {
        ModelMapper modelMapper = (ModelMapper) SpringApplicationContext.getBean("modelMapper");
        Section section = modelMapper.map(this, Section.class);
        return section;
    }
}

