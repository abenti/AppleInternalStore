package com.example.appleinternalstore.model;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import java.util.List;

 class Cart {
    @Column(nullable=false, unique=true)
    @NotBlank(message = "* Product List is required")
    private List<Product> productList;

    @Column(nullable=false, unique=true)
    @NotBlank(message = "* User is required")
    private User user;

}
