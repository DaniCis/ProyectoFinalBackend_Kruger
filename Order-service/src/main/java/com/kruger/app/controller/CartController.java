package com.kruger.app.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kruger.app.model.Cart;
import com.kruger.app.repository.CartRepository;
import com.kruger.app.service.CartService;

@RestController
@RequestMapping("/cart")
public class CartController {
	
	@Autowired
	CartService service;
	
	@Autowired
	CartRepository repository;
	
	@RequestMapping(method=RequestMethod.GET, produces="application/json" )
	public Iterable<Cart> findAll(){
		return service.findAll();
	}
	@RequestMapping(value = "/save", method = RequestMethod.POST, produces = "application/json")
	public Cart save(@RequestBody Cart entity) {
		return service.save(entity);
	}
	
	 @RequestMapping(value = "/{id}/show", method = RequestMethod.GET, produces = "application/json")
	 public Optional<Cart> findById(@PathVariable Integer id){
		return service.findById(id);
	}
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = "application/json")
	public void delete(@PathVariable Integer id) {
		service.deleteById(id);
	}

}
