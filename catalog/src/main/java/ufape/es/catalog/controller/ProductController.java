package ufape.es.catalog.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import ufape.es.catalog.controller.request.ProductRequest;
import ufape.es.catalog.controller.response.ProductResponse;
import ufape.es.catalog.facade.Catalog;
import ufape.es.core.event.Event;
import ufape.es.core.event.Event.Type;
import ufape.es.core.event.Publisher;






import ufape.es.catalog.model.Product;

@RestController
public class ProductController {
    @Autowired
    private Catalog facade;
    @Autowired
    private Publisher publisher;


    @PostMapping("/product")
    Product createProduct (@Valid @RequestBody ProductRequest newObj) {
         Product product = facade.saveProduct(newObj.convertToEntity());
         // é pra ser Long e ProductDTO, ai como n tem, fds por enquanto
         Event<Long,Integer> event = new Event<Long,Integer>(Type.CREATE, product.getId(), 2);
		 publisher.sendMessage("inventory-out-0", event);
         return product;
    }

    @GetMapping("/product")
    List<ProductResponse> getAllProduct() {
        return facade.listProducts()
                .stream()
                .map(ProductResponse::new)
                .toList();
    }

    @GetMapping("/product/{id}")
    ProductResponse getProductById(@PathVariable long id) {
        return new ProductResponse(facade.findProductById(id));
    }

   

    @DeleteMapping("/product/{id}")
    void deleteProduct(@PathVariable long id){
        facade.deleteProduct(id);
    }
    
}
