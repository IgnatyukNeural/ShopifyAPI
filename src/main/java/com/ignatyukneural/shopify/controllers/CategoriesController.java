package com.ignatyukneural.shopify.controllers;

import com.ignatyukneural.shopify.models.Category;
import com.ignatyukneural.shopify.repositories.CategoryRepository;
import com.ignatyukneural.shopify.validator.AvailabilityValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("api/v1/categories")
public class CategoriesController {

    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping("/getallcategories")
    public List<Category> getAll() {
        return categoryRepository.findAll();
    }

    @PostMapping("/createcategory")
    public void createCategory(Category category) {
        if(AvailabilityValidator.checkCategoryNameAvailability(category.categoryName) == true) {
            categoryRepository.save(category);
        }
    }

}
