package com.example.appleinternalstore.service;

import com.example.appleinternalstore.model.Home;
import com.example.appleinternalstore.repository.HomeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HomeService {

    HomeRepository repository;

    public HomeService(HomeRepository productRepository) {
        repository = productRepository;
    }

    public List<Home> getAllHomeCategories() {
        return repository.findAll();
    }
}
