package com.giri.hotelbooking.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.giri.hotelbooking.models.User;
import com.giri.hotelbooking.services.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private UserService service;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User user) {
        System.out.println("User name in controller " + user.getName());
        System.out.println("User email in controller " + user.getEmail());
        System.out.println("User password in controller " + user.getPassword());
        System.out.println("User role in controller " + user.getRole());
        return ResponseEntity.ok(service.register(user));
    }
    
}
