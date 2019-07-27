package com.ignatyukneural.shopify.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String productName;
    private String productDescription;

    @ManyToOne
    @JoinTable(name = "parentSubcategoryId")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Subcategory parentSubcategory;

    public String getProductName() {
        return productName;
    }

    @JsonIgnore
    public Subcategory getParentSubcategory() {
        return parentSubcategory;
    }

    public Integer getParentSubcategoryId() {
        return parentSubcategory.id;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public Integer getId() {
        return id;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public void setParentSubcategory(Subcategory parentSubcategory) {
        this.parentSubcategory = parentSubcategory;
    }
}
