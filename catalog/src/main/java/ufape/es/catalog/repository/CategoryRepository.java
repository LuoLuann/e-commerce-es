package ufape.es.catalog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ufape.es.catalog.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Category findByNameIgnoreCase(String name);
}
