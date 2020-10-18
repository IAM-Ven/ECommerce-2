package com.example.dfcommerce.repositories;

import com.example.dfcommerce.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IProductRepository extends JpaRepository<Product, Integer> {
    List<Product> findAll();
}
