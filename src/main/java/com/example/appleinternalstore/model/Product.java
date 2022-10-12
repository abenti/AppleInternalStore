package com.example.appleinternalstore.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name="product")
public class Product {
   @Id
   @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;

    @Column(nullable=false)
    @NotBlank(message = "* Product Name is required")
    private String productName;

    @Column(nullable=false)
    @NotBlank(message = "* Product Price is required")
    private float productPrice;

    @Column(nullable=false)
    @NotBlank(message = "* Product Description is required")
    private String productDescription;

    @Column(nullable=false)
    @NotBlank(message = "* Product Images are required")
    @Size(max=3)
    private String productImages;

    @Column(nullable=false)
    @NotBlank(message = "* Product Category is required")
    private String productCategory;

    @Column(nullable=false)
    @NotBlank(message = "* Product Discount is required")
    private float productDiscount;
}
