package com.example.appleinternalstore.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(nullable = false)
    @NotBlank(message = "* Product Name is required")
    private String productName;

    @Column(nullable = false)
    @NotBlank(message = "* Product Price is required")
    private float productPrice;

    @Column(nullable = false)
    @NotBlank(message = "* Product Description is required")
    private String productDescription;

    @Column(nullable = false)
    @NotBlank(message = "* Product Images are required")
    @Size(max = 3)
    private String productImages;

    @Column(nullable = false)
    @NotBlank(message = "* Product Category is required")
    private String productCategory;

    @Column(nullable = false)
    @NotBlank(message = "* Product Discount is required")
    private float productDiscount;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public float getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(float productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public String getProductImages() {
        return productImages;
    }

    public void setProductImages(String productImages) {
        this.productImages = productImages;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    public float getProductDiscount() {
        return productDiscount;
    }

    public void setProductDiscount(float productDiscount) {
        this.productDiscount = productDiscount;
    }
}
