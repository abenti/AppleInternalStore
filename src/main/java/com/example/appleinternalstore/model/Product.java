package com.example.appleinternalstore.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;

@Document("Products")
@Data
public class Product {

    @Id
    private String id;

    @NotBlank(message = "* Product Name is required")
    private String name;

    @NotBlank(message = "* Product Price is required")
    private float price;

    @NotBlank(message = "* Product Description is required")
    private String description;

    @NotBlank(message = "* Product Images are required")
    private String image;

    @NotBlank(message = "* Product Category is required")
    private String category;

    private String[] size;

    private String[] color;

}
