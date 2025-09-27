package com.giri.hotelbooking.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.giri.hotelbooking.models.Booking;
import com.giri.hotelbooking.repositories.BookingRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/bookings")
public class BookingController {
    @Autowired 
    private BookingRepository bookRepo;

    @PostMapping
    public Booking book(@RequestBody Booking booking) {
        booking.setStatus("CONFIRMED");
        return bookRepo.save(booking);
    }

    @GetMapping("/user/{id}")
    public List<Booking> getUserBookings(@PathVariable Long id) {
        return bookRepo.findByUserId(id);
    }
    
}
