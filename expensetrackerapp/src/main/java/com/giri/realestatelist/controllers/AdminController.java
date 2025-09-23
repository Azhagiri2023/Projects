package com.giri.realestatelist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.giri.realestatelist.models.FinalEstate;
import com.giri.realestatelist.models.Seller;
import com.giri.realestatelist.repositories.FinalEstateRepository;
import com.giri.realestatelist.repositories.SellerRepository;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@Controller
@RequestMapping("/admin")
public class AdminController {
    
    @Autowired
    private SellerRepository sellerRepository;

    @Autowired
    private FinalEstateRepository finalEstateRepository;

    @GetMapping("/dashboard")
    public String dashboardHome(Model model ) {
        long totalSellers = sellerRepository.count();
        long totalApproved = finalEstateRepository.count();
        model.addAttribute("totalSellers", totalSellers);
        model.addAttribute("totalApproved", totalApproved);
        model.addAttribute("content", "admin_dashboard_home"); // injects fragment
        return "admin_dashboard";
    }

    @GetMapping("delete-approved/{id}")
    public String deleteApproved(@PathVariable Long id) {
        finalEstateRepository.deleteById(id);
        return "redirect:/admin/dashboard/approved";
    }
    
    @GetMapping("/dashboard/sellers")
    public String sellersPage(Model model) {
        List<Seller> sellers = sellerRepository.findAll();
        model.addAttribute("sellers", sellers);
        model.addAttribute("content", "admin_sellers");
        return "admin_sellers";
    }

    @GetMapping("/dashboard/approved")
    public String approvedPage(Model model) {
        List<FinalEstate> approved = finalEstateRepository.findAll();
        model.addAttribute("approved", approved);
        model.addAttribute("content", "admin_approved");
        return "admin_approved";
    }

    @GetMapping("/delete/{id}")
    public String deleteSeller(@PathVariable Long id, Model model) {
        sellerRepository.deleteById(id);
        model.addAttribute("approvedList", finalEstateRepository.findAll());
        return "redirect:/admin/dashboard/sellers";
    }
    

    @GetMapping("/approve/{id}")
    public String approveSeller(@PathVariable Long id, Model model) {
        Seller seller = sellerRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Seller not found"));
        FinalEstate finalEstate = new FinalEstate();
        finalEstate.setPropertyName(seller.getPropertyName());
        finalEstate.setPropertyType(seller.getPropertyType());
        finalEstate.setSquareFeet(seller.getSquareFeet());
        finalEstate.setRate(seller.getRate());
        finalEstate.setPlace(seller.getPlace());
        finalEstate.setCity(seller.getCity());
        finalEstate.setState(seller.getState());
        finalEstate.setPostalCode(seller.getPostalCode());
        finalEstate.setPropertyCategory(seller.getPropertyCategory());
        finalEstate.setAmenities(seller.getAmenities());
        finalEstate.setFurnished(seller.getFurnished());
        finalEstate.setBuiltYear(seller.getBuiltYear());
        finalEstate.setDescription(seller.getDescription());
        finalEstate.setLandOwner(seller.getLandOwner());
        finalEstate.setContact(seller.getContact());
        finalEstate.setImageUrl(seller.getImageUrl());

        finalEstateRepository.save(finalEstate);
        sellerRepository.deleteById(id);
        model.addAttribute("approvedList", finalEstateRepository.findAll());
        return "redirect:/admin/dashboard/sellers";
    }
    
    
    

    

}
