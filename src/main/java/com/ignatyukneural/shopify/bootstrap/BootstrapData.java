package com.ignatyukneural.shopify.bootstrap;

import com.ignatyukneural.shopify.models.Category;
import com.ignatyukneural.shopify.models.Product;
import com.ignatyukneural.shopify.models.Subcategory;
import com.ignatyukneural.shopify.repositories.CategoryRepository;
import com.ignatyukneural.shopify.repositories.ProductRepository;
import com.ignatyukneural.shopify.repositories.SubcategoryRepository;
import com.ignatyukneural.shopify.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

    CategoryRepository categoryRepository;
    SubcategoryRepository subcategoryRepository;
    UserRepository userRepository;
    ProductRepository productRepository;

    public BootstrapData(CategoryRepository categoryRepository, SubcategoryRepository subcategoryRepository, UserRepository userRepository, ProductRepository productRepository) {
        this.categoryRepository = categoryRepository;
        this.subcategoryRepository = subcategoryRepository;
        this.userRepository = userRepository;
        this.productRepository = productRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Category category = new Category();
        category.setCategoryName("Electronics");
        category.setCategoryDescription("Electronic things that you use on daily basis");
        categoryRepository.save(category);

        Category category1 = new Category();
        category1.setCategoryName("Food for animals");
        category1.setCategoryDescription("Quality food for your puppy, kitty, or whatever you have there");
        categoryRepository.save(category1);

        Subcategory subcategory = new Subcategory();
        subcategory.setSubcategoryName("Laptops");
        subcategory.setParentCategory(category);
        subcategoryRepository.save(subcategory);

        Product product = new Product();
        product.setProductName("ASUS Laptop for gaming");
        product.setProductDescription("A gaming laptop with gtx 1050ti on board");
        product.setParentSubcategory(subcategory);
        productRepository.save(product);

    }
}
