package com.giri.realestatelist.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Seller {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String propertyName;
    private String propertyType; // Rent or Sale
    private String squareFeet;
    private Double rate;
    private String place;
    private String landOwner;
    private String contact;
    private String imageUrl;
    @Column(columnDefinition = "TEXT")  // Cloudinary URL
    private String description; // Optional property description
    private String status; // Pending, Approved, Rejected
    private String city;
    private String state;
    private String postalCode;
    private String propertyCategory; // e.g., Apartment, House, Land
    private String amenities; // e.g., Pool, Parking, Gym
    private String furnished; // Yes/No
    private String builtYear; // Year of construction
}
