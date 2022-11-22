package com.example.oopsprojectbackend.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CategoryService {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }


    public List<Category> getCategories(){
        return categoryRepository.findAll();
    }

    public void addNewCategories(Category[] categories) {
        for(int i = 0; i< categories.length; i++) {
            Optional<Category> categoryOptional = categoryRepository.findCategoryById(categories[i].getId());
            if (categoryOptional.isPresent()) {
                throw new IllegalStateException("category exists");
            }
            categoryRepository.save(categories[i]);
        }
    }
}
