package com.kruger.app.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.kruger.app.common.Product;
import com.kruger.app.model.Order;
import com.kruger.app.repository.OrderRepository;

@Service
public class OrderService {
	
	@Autowired
	private OrderRepository repository;
	
	@Autowired
	private RestTemplate restTemplate;
	static final String PRODUCT_URL_MS="http://localhost:8006/";
	
	
//	public List<Order> lislistarproduc(){
//		
//		//List<Product> product = Arrays.asList(restTemplate.getForObject(PRODUCT_URL_MS+"/product", Product[].class));
//		return null;
//	}
	
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
