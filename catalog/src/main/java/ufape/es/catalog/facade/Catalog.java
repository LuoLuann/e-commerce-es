package ufape.es.catalog.facade;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ufape.es.catalog.model.Category;
import ufape.es.catalog.model.Product;
import ufape.es.catalog.service.CategoryServiceInterface;
import ufape.es.catalog.service.ProductServiceInterface;


@Service
public class Catalog {
    @Autowired
    private CategoryServiceInterface categoryRepository;
    @Autowired
    private ProductServiceInterface productRepository;

    public Category saveCategory(Category entity) {
        return categoryRepository.saveCategory(entity);
    }

    public List<Category> listCategories() {
        return categoryRepository.listCategories();
    }

    public void deleteCategory(Long id) {
        categoryRepository.deleteCategory(id);
    }

    public void deleteCategory(Category entity) {
        categoryRepository.deleteCategory(entity);
    }

    public Category findCategory(Long id) {
        return categoryRepository.findCategory(id);
    }

    public List<Product> listProducts(String description) {
        return productRepository.listProducts(description);
    }

    public List<Product> listProductsByCategory(String name) {
        return productRepository.listProductsByCategory(name);
    }

    public Product saveProduct(Product entity) {
        return productRepository.saveProduct(entity);
    }

    public List<Product> listProducts() {
        return productRepository.listProducts();
    }

    public Product findProductById(Long id) {
        return productRepository.findProductById(id);
    }

    public void deleteProduct(Long id) {
        productRepository.deleteProduct(id);
    }

    public void deleteProduct(Product entity) {
        productRepository.deleteProduct(entity);
    }
}
