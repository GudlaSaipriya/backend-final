package com.dxc2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dxc2.model.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {

}
