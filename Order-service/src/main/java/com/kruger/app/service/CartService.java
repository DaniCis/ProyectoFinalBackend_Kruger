package com.kruger.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kruger.app.model.Cart;
import com.kruger.app.repository.CartRepository;

@Service
public class CartService {

	@Autowired
	private CartRepository repository;
	
	public Iterable<Cart> findAll(){
		return repository.findAll();
	}
	
	public Cart save(Cart entity) {
		return repository.save(entity);
		
	}
	public  void  deleteById(Integer id) {
		 repository.deleteById(id);
		
	}
	
	public Optional<Cart> findById(Integer id){
		return repository.findById(id);
	}
}
