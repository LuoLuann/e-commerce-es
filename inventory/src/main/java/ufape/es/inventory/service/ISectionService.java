package ufape.es.inventory.service;

import java.util.List;

import ufape.es.inventory.model.Section;

public interface ISectionService {
    Section createSection(Section section);
    Section getSection(Long id);
    List<Section> getAllSections();
    Section updateSection(Section section);
    void deleteSection(Long id);
}
