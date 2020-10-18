package com.example.dfcommerce.services;

import com.example.dfcommerce.repositories.IPaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    @Autowired
    IPaymentRepository productsRepository;
}
