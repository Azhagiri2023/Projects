package com.giri.realestatelist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.giri.realestatelist.models.FinalEstate;
import com.giri.realestatelist.repositories.FinalEstateRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class BuyerController {
    
    @Autowired
    private FinalEstateRepository finalEstateRepository;

    @GetMapping("/buyer/home")
    public String getAllProperties(Model model) {
        List<FinalEstate> properties = finalEstateRepository.findAll();
        model.addAttribute("properties", properties);
        return "buyer";
    }

    @GetMapping("/buyer/view/{id}")
    public String viewProperty(@PathVariable Long id, Model model) {
        FinalEstate property = finalEstateRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Property not found: " + id));
        model.addAttribute("property", property);
        return "buyer_view";
    }

    @GetMapping("/buyer/search")
    public String searchProperties(
        @RequestParam(required = false) String city,
        @RequestParam(required = false) String type,
        @RequestParam(required = false) String category,
        @RequestParam(required = false) Double minRate,
        @RequestParam(required = false) Double maxRate,
        Model model) {

        List<FinalEstate> properties = finalEstateRepository.searchProperties(
            (city == null || city.trim().isEmpty()) ? null : city,
            (type == null || type.trim().isEmpty()) ? null : type,
            (category == null || category.trim().isEmpty()) ? null : category,
            minRate,
            maxRate);

        model.addAttribute("properties", properties);
        return "buyer";
    }
    
    
}
