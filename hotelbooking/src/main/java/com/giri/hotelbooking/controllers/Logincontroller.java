package com.giri.hotelbooking.controllers;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.RestController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;

import com.giri.hotelbooking.models.User;
import com.giri.hotelbooking.services.UserService;
//import org.springframework.web.bind.annotation.RequestBody;


//import ch.qos.logback.core.model.Model;

@Controller
public class Logincontroller {

    @Autowired
    private UserService service;

    @GetMapping("/login")
    public String loginPage() {
        return "login"; 
    }

    // @PostMapping("/login")
    // public String postMethodName(@RequestBody String entity) {
    //     return entity;
    // }
    

    @GetMapping("/register")
    public String registerPage(org.springframework.ui.Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute("user") User user) {
        service.register(user);
        return "redirect:/login?registered";

    }
    // public ResponseEntity<?> register(@RequestBody User user) {
    //     System.out.println("User name in controller " + user.getName());
    //     System.out.println("User email in controller " + user.getEmail());
    //     System.out.println("User password in controller " + user.getPassword());
    //     System.out.println("User role in controller " + user.getRole());
    //     return ResponseEntity.ok(service.register(user));
    // }


}
