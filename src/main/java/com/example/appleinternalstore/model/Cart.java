package com.example.appleinternalstore.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("cart")
@Data
public class Cart {

    @Id
    private String id;

    private Product product;

    private Integer quantity;

    private float total;

}
