package com.example.appleinternalstore.controller;

import com.example.appleinternalstore.model.Order;
import com.example.appleinternalstore.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    public ResponseEntity addToCart(@RequestBody Order order) {
        Optional<Order> result = orderService.save(order);
        if (result.isEmpty()) return new ResponseEntity(HttpStatus.NO_CONTENT);
        else return new ResponseEntity(result.get(), HttpStatus.OK);
    }

    @GetMapping
    ResponseEntity getAllOrders() {
        List<Order> result = orderService.getAllCarts();
        if (result.isEmpty()) return new ResponseEntity(HttpStatus.NO_CONTENT);
        else return new ResponseEntity(result, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    ResponseEntity deleteCartItem(@PathVariable String id) {
        Boolean isDeletedSuccessful = orderService.deleteOrderById(id);
        if (isDeletedSuccessful) return new ResponseEntity(HttpStatus.OK);
        else
            return new ResponseEntity("No matching order found for " + id + ". Please check again.", HttpStatus.NO_CONTENT);
    }

}
