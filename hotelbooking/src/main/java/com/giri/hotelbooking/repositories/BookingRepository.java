package com.giri.hotelbooking.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.giri.hotelbooking.models.Booking;
import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long>{
    List<Booking> findByUserId(Long userId);
} 
