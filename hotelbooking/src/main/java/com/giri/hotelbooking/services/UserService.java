package com.giri.hotelbooking.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.giri.hotelbooking.models.User;
import com.giri.hotelbooking.repositories.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepo;

    @Autowired
    private PasswordEncoder encoder;

    public User register(User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        user.setRole("USER");
        System.out.println("service level user name " + user.getName());
        System.out.println("service level user email " + user.getEmail());
        System.out.println("service level user password " + user.getPassword());
        System.out.println("service level user role " + user.getRole());
        return userRepo.save(user);
    }

}
