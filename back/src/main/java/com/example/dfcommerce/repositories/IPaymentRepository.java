package com.example.dfcommerce.repositories;

import com.example.dfcommerce.models.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPaymentRepository extends JpaRepository<Payment, Integer> {
}
