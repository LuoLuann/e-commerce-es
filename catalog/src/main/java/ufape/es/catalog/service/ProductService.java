package ufape.es.catalog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ufape.es.catalog.model.Product;
import ufape.es.catalog.repository.ProductRepository;
import ufape.es.core.exception.*;


@Service
public class ProductService implements ProductServiceInterface {
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
        if (productRepository.findByNameIgnoreCaseAndCategoryId(entity.getName(), entity.getCategory().getId()) == null) {
            return productRepository.save(entity);
        } else {
            throw new DuplicateRecordException("The product [" + entity.getName() + "] is already registered in the system.");
        }
    }

    @Override
    public List<Product> listProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product findProductById(Long id) {
        return productRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Preço de produto não encontrada (id: " + id + ")"));
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
