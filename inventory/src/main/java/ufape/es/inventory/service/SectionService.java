package ufape.es.inventory.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ufape.es.inventory.model.Section;
import ufape.es.inventory.repository.SectionRepository;
import ufape.es.inventory.service.interfaces.ISection;

@Service
public class SectionService implements ISection {

    @Autowired
    private SectionRepository sectionRepository;

    @Override
    public Section createSection(Long warehouseId, Section section) {
        return sectionRepository.save(section);
    }

    @Override
    public Section getSection(Long id) {
        return sectionRepository.findById(id).orElse(null);
    }

    @Override
    public List<Section> getSections() {
        return sectionRepository.findAll();
    }

    @Override
    public Section updateSection(Long id, Section section) {
        Section sectionToUpdate = sectionRepository.findById(id).orElse(null);
        if (sectionToUpdate == null) {
            return null;
        }
        sectionToUpdate.setName(section.getName());
        return sectionRepository.save(sectionToUpdate);
    }

    @Override
    public void deleteSection(Long id) {
        sectionRepository.deleteById(id);
    }
}
