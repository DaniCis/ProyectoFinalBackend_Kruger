package com.kruger.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kruger.app.model.Payment;

public interface PaymentRepository extends JpaRepository<Payment,Long> {

}