package com.example.appleinternalstore.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Document("product")
public class Product {
    @Id
    private int id;

    @NotBlank(message = "* Product Name is required")
    private String productName;

    private Cart cart;

    @NotBlank(message = "* Product Price is required")
    private float productPrice;

    @NotBlank(message = "* Product Description is required")
    private String productDescription;

    @NotBlank(message = "* Product Images are required")
    @Size(max = 3)
    private String productImages;

    @NotBlank(message = "* Product Category is required")
    private String productCategory;

    @NotBlank(message = "* Product Discount is required")
    private float productDiscount;

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

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
