package com.example.appleinternalstore.controller;

import com.example.appleinternalstore.model.Cart;
import com.example.appleinternalstore.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/carts")
public class CartController {

    @Autowired
    private CartService cartService;

    @PostMapping
    public ResponseEntity addToCart(@RequestBody Cart cart) {
//        cart.setId(sequenceGeneratorService.generateSequence(Cart.SEQUENCE_NAME));
        Optional<Cart> result = cartService.save(cart);
        if (result.isEmpty()) return new ResponseEntity(HttpStatus.NO_CONTENT);
        else return new ResponseEntity(result.get(), HttpStatus.OK);
    }

    @GetMapping
    ResponseEntity getAllCarts() {
        List<Cart> result = cartService.getAllCarts();
        if (result.isEmpty()) return new ResponseEntity(HttpStatus.NO_CONTENT);
        else return new ResponseEntity(result, HttpStatus.OK);
    }

    @PatchMapping
    public ResponseEntity updateCart(@RequestBody Cart cart) {
        Boolean isUpdateSuccessful = cartService.updateCart(cart);
        String errorMessage = "Unprocessable entity. Please check your request body";
        if (isUpdateSuccessful) return new ResponseEntity(HttpStatus.OK);
        else return new ResponseEntity(errorMessage, HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @DeleteMapping("/{id}")
    ResponseEntity deleteCartItem(@PathVariable String id) {
        Boolean isDeletedSuccessful = cartService.deleteCartItem(id);
        if (isDeletedSuccessful) return new ResponseEntity(HttpStatus.OK);
        else
            return new ResponseEntity("No matching cart found for " + id + ". Please check again. Please check again.", HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/deleteAll")
    ResponseEntity deleteAllCartItems() {
        cartService.deleteAll();
        return new ResponseEntity(HttpStatus.OK);
    }

}
