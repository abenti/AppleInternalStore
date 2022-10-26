package com.example.appleinternalstore.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("order_product")
@Data
public class OrderProduct {

    private Product product;

    private int quantity;

}
