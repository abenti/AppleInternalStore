package com.example.appleinternalstore.repository;

import com.example.appleinternalstore.model.Cart;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends MongoRepository<Cart, Long> {

}
