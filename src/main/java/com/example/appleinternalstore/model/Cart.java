package com.example.appleinternalstore.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document("cart")
public class Cart {

   @Id
   private int id;

   private List<Product> productList;

   private String userId;

   public int getId() {
      return id;
   }

   public void setId(int id) {
      this.id = id;
   }

   public List<Product> getProductList() {
      return productList;
   }

   public void setProductList(List<Product> productList) {
      this.productList = productList;
   }

   public String getUserId() {
      return userId;
   }

   public void setUserId(String userId) {
      this.userId = userId;
   }
}
