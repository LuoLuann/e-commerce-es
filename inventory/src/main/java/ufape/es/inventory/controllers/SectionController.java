package ufape.es.inventory.controllers;

import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ufape.es.inventory.controllers.dto.requests.SectionRequest;
import ufape.es.inventory.controllers.dto.responses.SectionResponse;
import ufape.es.inventory.facade.Facade;
import ufape.es.inventory.model.Section;

import java.util.List;

@RestController
public class SectionController {

    @Autowired
    private Facade facade;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("/section")
    public Section createSection(@Valid @RequestBody SectionRequest newObj) {
        return facade.createSection(newObj.convertToEntity());
    }

    @PutMapping("/section/{id}")
    public SectionResponse updateSection(@PathVariable Long id, @Valid @RequestBody SectionRequest obj) {
        Section oldObject = facade.getSection(id);

        modelMapper.map(obj, oldObject);

        return new SectionResponse(facade.updateSection(oldObject));
    }

    @GetMapping("/section")
    public List<SectionResponse> getAllSections() {
        return facade.getAllSections()
                .stream()
                .map(SectionResponse::new)
                .toList();
    }

    @GetMapping("/section/{id}")
    public SectionResponse getSectionById(@PathVariable long id) {
        return new SectionResponse(facade.getSection(id));
    }

    @DeleteMapping("/section/{id}")
    public void deleteSection(@PathVariable long id) {
        facade.deleteSection(id);
    }
}

