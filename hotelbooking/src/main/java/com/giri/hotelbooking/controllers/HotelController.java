package com.giri.hotelbooking.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.giri.hotelbooking.models.Hotel;
import com.giri.hotelbooking.repositories.HotelRepository;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/hotels")
public class HotelController {
    @Autowired
    private HotelRepository hotelRepo;

    @GetMapping()
    public List<Hotel> getAll() {
        return hotelRepo.findAll();
    }
    
    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public Hotel create(@RequestBody Hotel hotel) {
        return hotelRepo.save(hotel);
    }
    
    
}
