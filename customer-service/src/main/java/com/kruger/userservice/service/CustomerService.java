package com.kruger.userservice.service;

import com.kruger.userservice.entity.Customer;
import com.kruger.userservice.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    RestTemplate restTemplate;

    public List<Customer> findAll(){
        return customerRepository.findAll();
    }

    public Customer getUserById(int id){
        return customerRepository.findById(id).orElse(null);
    }

    public Customer save(Customer customer){
        Customer customerNew = customerRepository.save(customer);
        return customerNew;
    }


}
