package com.kruger.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kruger.app.model.Order;

public interface OrderRepository extends JpaRepository<Order,Integer>{

}
	