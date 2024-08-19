package ufape.es.catalog.registration;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ufape.es.catalog.model.Product;
import ufape.es.catalog.repository.ProductRepository;


@Service
public class ProductRegistration implements ProductRegistrationInterface {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> listProducts(String description) {
        return productRepository.findByDescriptionContainingIgnoreCase(description);
    }

    @Override
    public List<Product> listProductsByCategory(String name) {
        return productRepository.findByCategory_Name(name);
    }

    @Override
    public Product saveProduct(Product entity) {
        return productRepository.save(entity);
    }

    @Override
    public List<Product> listProducts() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> findProductById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public void deleteProduct(Product entity) {
        productRepository.delete(entity);
    }
}
