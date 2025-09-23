package com.giri.realestatelist.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class FinalEstate {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String propertyName;
    private String propertyType;       // Rent or Sale
    private String squareFeet;
    private Double rate;
    private String place;
    private String city;
    private String state;
    private String postalCode;
    private String propertyCategory;   // Apartment, House, Land
    private String amenities;          // Pool, Parking, Gym
    private String furnished;          // Yes/No
    private String builtYear;          // Year of construction
    private String description;        // Short description
    private String landOwner;
    private String contact;
    private String imageUrl;           // Cloudinary URL

}
