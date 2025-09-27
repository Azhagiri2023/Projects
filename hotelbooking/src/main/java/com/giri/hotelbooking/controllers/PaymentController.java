package com.giri.hotelbooking.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.giri.hotelbooking.models.Payment;

@RestController
@RequestMapping("/payments")
public class PaymentController {
    @PostMapping
    public Payment pay(@RequestBody Payment payment) {
        payment.setStatus("SUCCESS");
        return payment;
    }
}
