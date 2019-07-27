package com.ignatyukneural.shopify.validator;

import com.ignatyukneural.shopify.models.Category;
import com.ignatyukneural.shopify.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AvailabilityValidator {

    @Autowired
    CategoryRepository categoryRepository;

    public static boolean checkCategoryNameAvailability(String categoryName) {
        List<Category> categories = new ArrayList<>();
        for(Category category : categories) {
            if(category.categoryName.equals(categoryName)) {
                return false;
            }
        }
        return true;
    }

}
