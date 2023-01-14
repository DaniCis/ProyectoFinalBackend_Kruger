package com.kruger.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kruger.app.model.Order;
import com.kruger.app.repository.OrderRepository;

@Service
public class OrderService {
	
	@Autowired
	private OrderRepository repository;
	
	public Iterable<Order> findAll(){
		return repository.findAll();
	}
	
	public Order save(Order entity) {
		return repository.save(entity);
		
	}
	public  void  deleteById(Integer id) {
		 repository.deleteById(id);
		
	}
	
	public Optional<Order> findById(Integer id){
		return repository.findById(id);
	}

}
