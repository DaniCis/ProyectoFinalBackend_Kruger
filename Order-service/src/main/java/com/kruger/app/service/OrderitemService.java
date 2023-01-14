package com.kruger.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kruger.app.model.Orderitem;
import com.kruger.app.repository.OrderitemRepository;

@Service
public class OrderitemService {

	
	@Autowired
	private OrderitemRepository repository;
	
	public Iterable<Orderitem> findAll(){
		return repository.findAll();
	}
	
	public Orderitem save(Orderitem entity) {
		return repository.save(entity);
		
	}
	public  void  deleteById(Integer id) {
		 repository.deleteById(id);
		
	}
	
	public Optional<Orderitem> findById(Integer id){
		return repository.findById(id);
	}
}
