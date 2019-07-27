package com.ignatyukneural.shopify.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.util.Collection;
import java.util.Set;

@Entity
@Table(name = "subcategories")
public class Subcategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    private String subcategoryName;

    @ManyToOne
    @JoinTable(name = "parentCategoryId")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Category parentCategory;

    @OneToMany(mappedBy = "parentSubcategory")
    private Collection<Product> products;

    public String getSubcategoryName() {
        return subcategoryName;
    }

    @JsonIgnore
    public Category getParentCategory() {
        return parentCategory;
    }

    public Integer getParentCategoryId() {
        return parentCategory.id;
    }

    public Integer getId() {
        return id;
    }

    public Collection<Product> getProducts() {
        return products;
    }

    public void setProducts(Collection<Product> products) {
        this.products = products;
    }

    public void setParentCategory(Category parentCategory) {
        this.parentCategory = parentCategory;
    }

    public void setSubcategoryName(String subcategoryName) {
        this.subcategoryName = subcategoryName;
    }

    public void setParentCategoryId(Integer id) {
        this.parentCategory.id = id;
    }


}
