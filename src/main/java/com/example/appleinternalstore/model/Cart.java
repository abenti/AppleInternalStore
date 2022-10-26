package com.example.appleinternalstore.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("cart")
@Data
public class Cart {

   @Transient
   public static final String SEQUENCE_NAME = "cart_sequence";

   @Id
   private Long id;

   private Product product;

   private Integer quantity;

}
