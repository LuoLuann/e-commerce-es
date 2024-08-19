package ufape.es.catalog.registration;

import java.util.List;
import java.util.Optional;

import ufape.es.catalog.model.Product;

public interface ProductRegistrationInterface {

    List<Product> listProducts(String description);

    List<Product> listProductsByCategory(String name);

    Product saveProduct(Product entity);

    List<Product> listProducts();

    Optional<Product> findProductById(Long id);

    void deleteProduct(Long id);

    void deleteProduct(Product entity);
}
