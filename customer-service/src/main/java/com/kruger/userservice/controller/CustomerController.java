package com.kruger.userservice.controller;

import com.kruger.userservice.entity.Customer;
import com.kruger.userservice.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
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

}
