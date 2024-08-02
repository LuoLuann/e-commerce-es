package ufape.es.catalog.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ufape.es.catalog.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByDescriptionContainingIgnoreCase(String description);
    List<Product> findByCategory_Name(String name);
}
