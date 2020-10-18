package com.example.dfcommerce.services;

import com.example.dfcommerce.repositories.IDiscountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DiscountService {

    @Autowired
    IDiscountRepository discountRepository;
}
