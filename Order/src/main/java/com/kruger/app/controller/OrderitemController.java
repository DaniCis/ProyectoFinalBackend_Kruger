package com.kruger.app.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.kruger.app.model.Orderitem;
import com.kruger.app.repository.OrderitemRepository;
import com.kruger.app.service.OrderitemService;




@RestController
@RequestMapping("/orderitem")
public class OrderitemController {
	@Autowired
	OrderitemService service;
	
	@Autowired
	OrderitemRepository repository;
	
	@RequestMapping(method=RequestMethod.GET, produces="application/json" )
	public Iterable<Orderitem> findAll(){
		return service.findAll();
	}
	@RequestMapping(value = "/save", method = RequestMethod.POST, produces = "application/json")
	public Orderitem save(@RequestBody Orderitem entity) {
		return service.save(entity);
	}
	
	 @RequestMapping(value = "/{id}/show", method = RequestMethod.GET, produces = "application/json")
	 public Optional<Orderitem> findById(@PathVariable Integer id){
		return service.findById(id);
	}
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = "application/json")
	public void delete(@PathVariable Integer id) {
		service.deleteById(id);
	}

}
