package com.kruger.app.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.kruger.app.model.Order;
import com.kruger.app.repository.OrderRepository;
import com.kruger.app.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {
	@Autowired
	OrderService service;
	
	@Autowired
	OrderRepository repository;

	@RequestMapping(method=RequestMethod.GET, produces="application/json" )
	public Iterable<Order> findAll(){
		return service.findAll();
	}
	
	// obteniendo datos de  microservicio product 
	@Autowired
	private RestTemplate restTemplate;
	static final String PRODUCT_URL_MS="http://localhost:8006/";
	
	@GetMapping("/product")
	public String fetchStudent() {
		return restTemplate.exchange(PRODUCT_URL_MS+"product", HttpMethod.GET, null, String.class).getBody();
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST, produces = "application/json")
	public Order save(@RequestBody Order entity) {
		return service.save(entity);
	}
	
	 @RequestMapping(value = "/{id}/show", method = RequestMethod.GET, produces = "application/json")
	 public Optional<Order> findById(@PathVariable Integer id){
		return service.findById(id);
	}
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = "application/json")
	public void delete(@PathVariable Integer id) {
		service.deleteById(id);
	}
}
