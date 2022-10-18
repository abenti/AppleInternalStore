package com.example.appleinternalstore.service;

import com.example.appleinternalstore.model.Product;
import com.example.appleinternalstore.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    ProductRepository repository;

    public ProductService(ProductRepository productRepository) {
        repository = productRepository;
    }

    public List<Product> getProductsByCategory(String category){
        return repository.findByProductCategory(category);
    }

    public List<Product> getAllProducts(){
        return repository.findAll();
    }
}
