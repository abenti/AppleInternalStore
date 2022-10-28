package com.example.appleinternalstore.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("order")
@Data
public class Order {

    @Id
    private String id;

    private Product product;

    private int quantity;

    private float total;

}
