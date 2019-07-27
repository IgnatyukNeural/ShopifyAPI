package com.ignatyukneural.shopify.controllers;

import com.ignatyukneural.shopify.models.Subcategory;
import com.ignatyukneural.shopify.repositories.SubcategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/subcategories")
public class SubcategoriesController {

    @Autowired
    SubcategoryRepository subcategoryRepository;

    @GetMapping("getallsubcategories")
    public List<Subcategory> getAll() {
        return subcategoryRepository.findAll();
    }

}
