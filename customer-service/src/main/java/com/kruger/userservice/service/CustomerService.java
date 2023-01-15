package com.kruger.userservice.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kruger.userservice.config.RestTemplateConfig;
import com.kruger.userservice.entity.Customer;
import com.kruger.userservice.feignclients.ReviewFeignClient;
import com.kruger.userservice.model.Product;
import com.kruger.userservice.model.Review;
import com.kruger.userservice.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    RestTemplateBuilder restTemplate;

    @Autowired
    ReviewFeignClient reviewFeignClient;

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

    public List<Review> getReviews(){

      List<Review> reviews=  restTemplate.build().getForObject("http://localhost:8006/review",List.class);
     return reviews;
    }

    public List<Product> getProducts(){

        List<Product> products = restTemplate.build().getForObject("http://localhost:8006/product",List.class);
        return products;
    }


    public Review saveReview(Review review) {
        Review review1= reviewFeignClient.save(review);
        return review1;
    }
}
