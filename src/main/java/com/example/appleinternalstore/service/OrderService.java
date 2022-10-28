package com.example.appleinternalstore.service;

import com.example.appleinternalstore.model.Order;
import com.example.appleinternalstore.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;

    public List<Order> getAllCarts() {
        return repository.findAll();
    }

    public Optional<Order> save(Order order) {
        return Optional.of(repository.save(order));
    }

    public Boolean deleteOrderById(String id) {
        Optional<Order> result = repository.findById(id);
        if (result.isEmpty()) return false;
        else {
            repository.deleteById(id);
            return true;
        }
    }
}
