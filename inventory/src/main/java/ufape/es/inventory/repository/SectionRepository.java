package ufape.es.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ufape.es.inventory.model.Section;

public interface SectionRepository extends JpaRepository<Section, Long> {
}
