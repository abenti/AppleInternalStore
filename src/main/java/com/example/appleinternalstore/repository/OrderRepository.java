package com.example.appleinternalstore.repository;

import com.example.appleinternalstore.model.Cart;
import com.example.appleinternalstore.model.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends MongoRepository<Order, Long> {

}
