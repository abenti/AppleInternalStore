package com.example.appleinternalstore.service;

import com.example.appleinternalstore.model.User;
import com.example.appleinternalstore.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository repository;

    public User findUser(User user) {
        List<User> foundUser = repository.findByUsernameAndPassword(user.getUsername(), user.getPassword());
        if(foundUser.isEmpty()) return null;
        else return foundUser.get(0);
    }

    public Optional<User> save(User user) {
        return Optional.of(repository.save(user));
    }
}
