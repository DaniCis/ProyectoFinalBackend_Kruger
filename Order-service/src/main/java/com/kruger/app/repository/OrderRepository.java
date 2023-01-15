package com.kruger.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kruger.app.model.Order;

public interface OrderRepository extends JpaRepository<Order,Integer>{
	


}
	