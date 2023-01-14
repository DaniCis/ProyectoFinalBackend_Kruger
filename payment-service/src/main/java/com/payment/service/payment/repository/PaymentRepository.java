package com.payment.service.payment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.payment.service.payment.model.Payment;

public interface PaymentRepository extends JpaRepository<Payment,Integer> {
    Payment findByOrderId(int orderId);
}
