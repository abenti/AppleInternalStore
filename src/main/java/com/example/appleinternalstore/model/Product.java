package com.example.appleinternalstore.model;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

public class Product {
    @Column(nullable=false, unique=true)
    @NotBlank(message = "* Product Name is required")
    private String productName;

    @Column(nullable=false, unique = true)
    @NotBlank(message = "* Product Price is required")
    private float productPrice;

    @Column(nullable=false, unique = true)
    @NotBlank(message = "* Product Description is required")
    private String productDescription;

    @Column(nullable=false)
    @NotBlank(message = "* Product Images are required")
    @Size(max=3)
    private List<String> productImages;

    @Column(nullable=false, unique=true)
    @NotBlank(message = "* Product Category is required")
    private List<String> productCategory;

    @Column(nullable=false)
    @NotBlank(message = "* Product Discount is required")
    private float productDiscount;
}
