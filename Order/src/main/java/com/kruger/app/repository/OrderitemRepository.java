package com.kruger.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kruger.app.model.Orderitem;

public interface OrderitemRepository extends JpaRepository<Orderitem, Integer>{

}
