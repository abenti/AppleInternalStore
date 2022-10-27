package com.example.appleinternalstore.controller;

import com.example.appleinternalstore.model.User;
import com.example.appleinternalstore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/login")
    public User login(@RequestBody User user) {
        return userService.findUser(user);
    }

    @PostMapping("/user")
    public ResponseEntity createUser(@RequestBody User user) {
        Optional<User> result = userService.save(user);
        if (result.isEmpty()) return new ResponseEntity(HttpStatus.NO_CONTENT);
        else return new ResponseEntity(result.get(), HttpStatus.OK);
    }

}
