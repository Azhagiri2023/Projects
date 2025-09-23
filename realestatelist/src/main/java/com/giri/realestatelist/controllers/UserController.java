package com.giri.realestatelist.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.giri.realestatelist.models.Role;
import com.giri.realestatelist.models.Users;
import com.giri.realestatelist.repositories.UsersRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @Autowired
    private UsersRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/login")
    public String loginPage() {
        return "login"; // This must be your login.html template
    }

    @GetMapping("/register")
    public String registerPage(Model model) {
        model.addAttribute("user", new Users());
        return "register"; // register.html template
    }

    @PostMapping("/register")
    public String register(Users user, Model model) {
        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            model.addAttribute("error", "Email already exists!");
            return "register";
        }

        // Encode password
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        // Default role (you can change this as needed)
        if (user.getRole() == null) {
            user.setRole(Role.CUSTOMER); // Default role
        }

        userRepository.save(user);
        model.addAttribute("success", "Registration successful! Please login.");
        return "login";
    }

    @GetMapping("/")
    public String home() {
        return "index"; // index.html
    }
    
    
    
    
    
}
