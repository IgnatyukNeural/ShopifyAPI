package com.ignatyukneural.shopify.controllers;

import com.ignatyukneural.shopify.models.Product;
import com.ignatyukneural.shopify.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/products")
public class ProductsController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("getallproducts")
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @GetMapping("getproduct/{id}")
    public Optional<Product> getProduct(@PathVariable Integer id) {
        return productRepository.findById(id);
    }

    @PostMapping("createproduct")
    public void createProduct(@RequestBody Product product) {
        productRepository.save(product);
    }

}
