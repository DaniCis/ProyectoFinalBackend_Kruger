package com.kruger.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kruger.app.model.Payment;
import com.kruger.app.service.PaymentService;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentService service;

    @PostMapping("/save")
    public Payment doPayment(@RequestBody Payment payment){
        return service.createPayment(payment);
    }

    @GetMapping()
    public List<Payment> findAll(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Payment getPayment(@PathVariable long id){
        return service.getPayment(id);
    }

}