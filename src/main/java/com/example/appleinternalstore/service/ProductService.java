package com.example.appleinternalstore.service;

import com.example.appleinternalstore.model.Product;
import com.example.appleinternalstore.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public List<Product> getProductsByCategory(String category){
        return repository.findByCategory(category);
    }

    public List<Product> getAllProducts(){
        return repository.findAll();
    }

    public Optional<Product> getProduct(String id){
        return repository.findById(id);
    }

    public Optional<Product> save(Product product){
        return Optional.of(repository.save(product));
    }
}
