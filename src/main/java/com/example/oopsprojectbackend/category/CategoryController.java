package com.example.oopsprojectbackend.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "oops/api/category")
public class CategoryController {

    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @CrossOrigin
    @GetMapping
    public List<Category> getCategories(){
        return categoryService.getCategories();
    }

    @CrossOrigin
    @PostMapping
    public void registerNewCategory(@RequestBody Category[] categories) {
        categoryService.addNewCategories(categories);
    }
}
