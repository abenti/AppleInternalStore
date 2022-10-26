package com.example.appleinternalstore.service;

import com.example.appleinternalstore.model.Cart;
import com.example.appleinternalstore.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartService {

    @Autowired
    private CartRepository repository;

    public List<Cart> getAllCarts() {
        return repository.findAll();
    }

    public Optional<Cart> save(Cart cart) {
        return Optional.of(repository.save(cart));
    }
}
