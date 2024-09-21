package ufape.es.catalog.service;

import java.util.List;
import java.util.Optional;

import ufape.es.catalog.model.Product;

public interface ProductServiceInterface {

    List<Product> listProducts(String description);

    List<Product> listProductsByCategory(String name);

    Product saveProduct(Product entity);

    List<Product> listProducts();

    Product findProductById(Long id);

    void deleteProduct(Long id);

    void deleteProduct(Product entity);
}
