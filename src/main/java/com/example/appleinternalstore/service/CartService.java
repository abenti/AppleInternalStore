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

    public Boolean updateCart(Cart updateCart){
        Optional<Cart> result = repository.findById(updateCart.getId());
        if(result.isEmpty()) return false;
        else {
            Cart cart = result.get();
            cart.setQuantity(updateCart.getQuantity());
            repository.save(cart);
            return true;
        }
    }

    public void deleteAll() {
        repository.deleteAll();
    }

    public Boolean deleteCartItem(Long id) {
        Optional<Cart> result = repository.findById(id);
        if(result.isEmpty()) return false;
        else {
            repository.deleteById(id);
            return true;
        }
    }
}
