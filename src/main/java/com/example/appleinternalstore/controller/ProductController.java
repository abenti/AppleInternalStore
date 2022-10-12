package com.example.appleinternalstore.controller;

import com.example.appleinternalstore.model.Product;
import com.example.appleinternalstore.repository.ProductRepository;
import com.example.appleinternalstore.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

    ProductService productService;

    public ProductController(ProductService repository) {
        productService = repository;
    }

    @GetMapping("/products")
    List<Product> getProductsByCategory(@RequestParam String category) {
        return productService.getProductsByCategory(category);
    }
}
