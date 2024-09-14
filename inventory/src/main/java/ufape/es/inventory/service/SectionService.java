package ufape.es.inventory.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ufape.es.inventory.model.Section;
import ufape.es.inventory.repository.SectionRepository;
import ufape.es.inventory.service.exception.ObjectNotFoundException;

@Service
public class SectionService implements ISectionService {

    @Autowired
    private SectionRepository sectionRepository;

    @Override
    public Section createSection(Section section) {
        return sectionRepository.save(section);
    }

    @Override
    public Section getSection(Long id) {
        return sectionRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Section not found (id: " + id + ")"));
    }

    @Override
    public List<Section> getAllSections() {
        return sectionRepository.findAll();
    }

    @Override
    public Section updateSection(Section section) {
        return sectionRepository.save(section);
    }

    @Override
    public void deleteSection(Long id) {
        sectionRepository.deleteById(id);
    }
}
