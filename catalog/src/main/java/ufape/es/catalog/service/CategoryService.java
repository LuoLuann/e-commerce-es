package ufape.es.catalog.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ufape.es.catalog.model.Category;
import ufape.es.catalog.repository.CategoryRepository;
import ufape.es.core.exception.*;

@Service
public class CategoryService implements CategoryServiceInterface {
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Category saveCategory(Category entity) {
        if (categoryRepository.findByNameIgnoreCase(entity.getName()) == null) {
            return categoryRepository.save(entity);
        } else {
            throw new DuplicateRecordException("The category [" + entity.getName() + "] is already registered in the system.");
        }
    }

    @Override
    public List<Category> listCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public void deleteCategory(Category entity) {
        categoryRepository.delete(entity);
    }

    @Override
    public Category findCategory(Long id) {
        Optional<Category> optional = categoryRepository.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        } else {
            throw new ObjectNotFoundException("There is no category with id: " + id);
        }
    }
}
