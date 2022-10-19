package com.example.appleinternalstore.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Table(name = "cart")
public class Cart {

   @Id
   @Column(name = "cart_id")
   @GeneratedValue(strategy = GenerationType.AUTO)
   private int id;

   @OneToMany(mappedBy="cart")
   private List<Product> productList;

   @Column(name="user_id")
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
