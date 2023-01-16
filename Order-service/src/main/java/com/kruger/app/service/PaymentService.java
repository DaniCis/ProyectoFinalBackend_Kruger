package com.kruger.app.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kruger.app.model.Payment;
import com.kruger.app.repository.PaymentRepository;

@Service
public class PaymentService {

    @Autowired
    PaymentRepository repository;
    
    public Payment createPayment(Payment payment){
        payment.setCreated(new Date());
        return repository.save(payment);
    }
    
     public Payment getPayment(long id){
        return repository.findById(id).orElse(null);
    }

    public List<Payment> findAll() {
        return  repository.findAll();
    }
}
