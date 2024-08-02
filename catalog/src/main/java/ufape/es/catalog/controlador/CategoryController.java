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
import ufape.es.catalog.controller.request.CategoryRequest;
import ufape.es.catalog.controller.response.CategoryResponse;
import ufape.es.catalog.service.CatalogService;
import jakarta.validation.Valid;

@RestController
public class CategoryController {
    @Autowired
    private CatalogService catalogService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("/category")
    public Category registerCategory(@Valid @RequestBody CategoryRequest newObj) {
        return catalogService.saveCategory(newObj.convertToBasicClass());
    }

    @GetMapping("/category")
    public List<CategoryResponse> listCategories() {
        List<CategoryResponse> response = new ArrayList<>();
        for (Category c : catalogService.listCategories())
            response.add(new CategoryResponse(c));
        return response;
    }

    @GetMapping("/category/{id}")
    public CategoryResponse loadCategory(@PathVariable long id) {
        return new CategoryResponse(catalogService.findCategory(id));
    }
}
