package com.example.appleinternalstore.controller;

import com.example.appleinternalstore.model.Home;
import com.example.appleinternalstore.service.HomeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    HomeService homeService;

    public UserController(HomeService service) {
        homeService = service;
    }

//    @GetMapping("/login")
//    public List<Home> getHome() {
//        return homeService.getAllHomeCategories();
//    }

}
