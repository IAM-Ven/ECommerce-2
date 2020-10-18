package com.example.dfcommerce.repositories;

import com.example.dfcommerce.models.Discount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDiscountRepository extends JpaRepository<Discount, Integer> {
}
