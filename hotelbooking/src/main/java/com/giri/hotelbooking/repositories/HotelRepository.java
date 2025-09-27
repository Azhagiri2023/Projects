package com.giri.hotelbooking.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.giri.hotelbooking.models.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, Long> {
    
}
