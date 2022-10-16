package com.example.appleinternalstore.controller;

import com.example.appleinternalstore.model.Product;
import com.example.appleinternalstore.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {

    ProductService productService;

    public ProductController(ProductService repository) {
        productService = repository;
    }

    @GetMapping("/products")
    public List<Product> getProductsByCategory(@RequestParam String category) {
//        return productService.getProductsByCategory(category);
        Product product = new Product();
        product.setId(12312);
        product.setProductName("Iphone 13 Prox Max");
        ArrayList list = new ArrayList();
        list.add(product);
//        list.add(product);
        return list;
    }


    @GetMapping("/allproducts")
    String getProducts() {
        return "working";
    }

}
