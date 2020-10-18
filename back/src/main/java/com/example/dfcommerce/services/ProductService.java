package com.example.dfcommerce.services;

import com.example.dfcommerce.models.Product;
import com.example.dfcommerce.repositories.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    IProductRepository productsRepository;

    public List<Product> findAll(){
        return productsRepository.findAll();
    }

    public Product addProduct(Product product){
        return productsRepository.save(product);
    }
}
