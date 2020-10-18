package com.example.dfcommerce.controllers;

import com.example.dfcommerce.models.Product;
import com.example.dfcommerce.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@CrossOrigin
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/all")
    public List<Product> getAllProducts(){
        return productService.findAll();
    }

    @PutMapping("/add")
    public Product addProduct(@RequestBody Product product){
        return productService.addProduct(product);
    }

}
