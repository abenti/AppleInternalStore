package com.example.appleinternalstore.controller;

import com.example.appleinternalstore.model.Home;
import com.example.appleinternalstore.service.HomeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HomeController {

    HomeService homeService;

    public HomeController(HomeService service) {
        homeService = service;
    }

    @GetMapping("/home")
    public List<Home> getHome() {
        return homeService.getAllHomeCategories();
    }

}
