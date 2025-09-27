package com.giri.hotelbooking.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.giri.hotelbooking.models.Hotel;
import com.giri.hotelbooking.repositories.HotelRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/search")
public class SearchController {
    @Autowired
    private HotelRepository hotelRepo;

    @GetMapping
    public List<Hotel> search(@RequestParam String city) {
        return hotelRepo.findAll().stream()
            .filter(h -> h.getCity().equalsIgnoreCase(city))
            .collect(Collectors.toList());
    }
    
}
