package com.kruger.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kruger.app.model.Cart;

public interface CartRepository extends JpaRepository<Cart, Integer>{

}
