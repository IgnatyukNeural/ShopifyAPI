package com.ignatyukneural.shopify.models;

import javax.persistence.*;
import java.util.Collection;
import java.util.Set;

@Entity
@Table(name = "categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    public String categoryName;
    public String categoryDescription;

    @OneToMany(mappedBy = "parentCategory")
    private Collection<Subcategory> subcategories;

    public Integer getId() {
        return id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public String getCategoryDescription() {
        return categoryDescription;
    }

    public Collection<Subcategory> getSubcategories() {
        return subcategories;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setSubcategories(Set<Subcategory> subcategories) {
        this.subcategories = subcategories;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public void setCategoryDescription(String categoryDescription) {
        this.categoryDescription = categoryDescription;
    }
}
