package com.example.appleinternalstore.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document("order")
@Data
public class Order {

    @Id
    private String id;

    private List<OrderProduct> orderProducts;

    private float amount;

}
