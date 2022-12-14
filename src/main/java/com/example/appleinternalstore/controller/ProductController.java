package com.example.appleinternalstore.controller;

import com.example.appleinternalstore.model.Product;
import com.example.appleinternalstore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/productList/{category}")
    public List<Product> getProductsByCategory(@PathVariable(value = "category") String category) {
        return productService.getProductsByCategory(category);
    }

    @PostMapping("/products")
    public ResponseEntity createProduct(@RequestBody Product product) {
        Optional<Product> result = productService.save(product);
        if (result.isEmpty()) return new ResponseEntity(HttpStatus.NO_CONTENT);
        else return new ResponseEntity(result.get(), HttpStatus.OK);
    }

    @GetMapping("/products/{id}")
    ResponseEntity getProduct(@PathVariable(value = "id") String id) {
        Optional<Product> result = productService.getProduct(id);
        if (result.isEmpty()) return new ResponseEntity(HttpStatus.NO_CONTENT);
        else return new ResponseEntity(result.get(), HttpStatus.OK);
    }

}
