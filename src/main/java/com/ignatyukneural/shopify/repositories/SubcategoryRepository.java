package com.ignatyukneural.shopify.repositories;

import com.ignatyukneural.shopify.models.Subcategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubcategoryRepository extends JpaRepository<Subcategory, Integer> {
}
