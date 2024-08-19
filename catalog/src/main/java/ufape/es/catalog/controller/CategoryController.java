package ufape.es.catalog.controller;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ufape.es.catalog.model.Category;
import ufape.es.catalog.controlador.request.CategoryRequest;
import ufape.es.catalog.controlador.response.CategoryResponse;
import ufape.es.catalog.facade.Catalog;
import jakarta.validation.Valid;
import ufape.es.catalog.controlador.request.CategoryRequest;
import ufape.es.catalog.controlador.response.CategoryResponse;

@RestController
public class CategoryController {
    @Autowired
    private Catalog catalog;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("/category")
    Category registerCategory(@Valid @RequestBody CategoryRequest newObj) {
        return catalog.saveCategory(newObj.convertToBasicClass());
    }

    @GetMapping("/category")
    List<CategoryResponse> listCategories() {
        List<CategoryResponse> response = new ArrayList<>();
        for (Category c : catalog.listCategories()) {
            response.add(new CategoryResponse(c));
        }
        return response;
    }

    @GetMapping("/category/{id}")
    CategoryResponse loadCategory(@PathVariable long id) {
        return new CategoryResponse(catalog.findCategory(id));
    }
}
