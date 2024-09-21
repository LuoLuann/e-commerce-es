package ufape.es.catalog.service;

import java.util.List;

import ufape.es.catalog.model.Category;

public interface CategoryServiceInterface {

    Category saveCategory(Category entity);

    List<Category> listCategories();

    void deleteCategory(Long id);

    void deleteCategory(Category entity);

    Category findCategory(Long id);
}
