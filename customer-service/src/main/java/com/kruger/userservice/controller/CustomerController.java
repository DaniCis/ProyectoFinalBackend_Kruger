package com.kruger.userservice.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.kruger.userservice.entity.Customer;
import com.kruger.userservice.model.Product;
import com.kruger.userservice.model.Review;
import com.kruger.userservice.service.CustomerService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;


    @GetMapping
    public ResponseEntity<List<Customer>> findAll(){
        List<Customer> customers = customerService.findAll();
        if(customers.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(customers);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> getById(@PathVariable("id") int id){
        Customer customer = customerService.getUserById(id);
        if(customer==null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(customer);
    }

    @PostMapping()
    public ResponseEntity<Customer> save(@RequestBody Customer customer){
        Customer customerNew = customerService.save(customer);
        return ResponseEntity.ok(customerNew);
    }

    @GetMapping("/reviews")
    public ResponseEntity<List<Review>> getReviews() {
        List<Review> review = customerService.getReviews();
        if(review == null)
            return ResponseEntity.notFound().build();
        List<Review> reviews = customerService.getReviews();
        return ResponseEntity.ok(reviews);
    }

    @PostMapping("/savereview")
    public ResponseEntity<Review> saveReview (@RequestBody Review review) throws JsonProcessingException {
        Review reviews= customerService.saveReview(review);

        return  ResponseEntity.ok(reviews);
    }
}
