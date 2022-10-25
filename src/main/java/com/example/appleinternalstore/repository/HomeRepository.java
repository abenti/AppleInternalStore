package com.example.appleinternalstore.repository;

import com.example.appleinternalstore.model.Home;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HomeRepository extends MongoRepository<Home, String> {

}
