package com.example.appleinternalstore.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document("order")
@Data
public class Order {

    @Transient
    public static final String SEQUENCE_NAME = "order_sequence";

    @Id
    private String id;

    private String userId;

    private List<OrderProduct> orderProducts;

    private float amount;

    private String status;

}
