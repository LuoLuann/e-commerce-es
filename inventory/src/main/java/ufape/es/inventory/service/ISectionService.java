package ufape.es.inventory.service;

import java.util.List;

import ufape.es.inventory.model.Section;

public interface ISectionService {
    Section createSection(Long warehouseId, Section section);
    Section getSection(Long id);
    List<Section> getSections();
    Section updateSection(Long id, Section section);
    void deleteSection(Long id);
}
