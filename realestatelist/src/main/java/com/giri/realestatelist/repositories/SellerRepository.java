package com.giri.realestatelist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.giri.realestatelist.models.Seller;

@Repository
public interface SellerRepository extends JpaRepository<Seller, Long>{
    
}
