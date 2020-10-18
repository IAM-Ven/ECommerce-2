package com.example.dfcommerce.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="product")
public class Product {
    @Id
    @GeneratedValue
    @Column(name="product_id")
    int id;

    @Column(name="name")
    String name;

    @Column(name="description")
    String description;

    @Column(name="category")
    String category;

    @Column(name="price")
    int price;

    @Column(name="inventory")
    int inventory;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "product_payments", joinColumns = @JoinColumn(name = "id_product"), inverseJoinColumns= @JoinColumn(name="id_payment"))
    List<Payment> paymentMethods= new ArrayList<>();

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "product_discounts", joinColumns = @JoinColumn(name = "id_product"), inverseJoinColumns= @JoinColumn(name="id_discount"))
    List<Discount> productDiscounts= new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getInventory() {
        return inventory;
    }

    public void setInventory(int inventory) {
        this.inventory = inventory;
    }

    public List<Payment> getPaymentMethods() {
        return paymentMethods;
    }

    public void setPaymentMethods(List<Payment> paymentMethods) {
        this.paymentMethods = paymentMethods;
    }

    public List<Discount> getProductDiscounts() {
        return productDiscounts;
    }

    public void setProductDiscounts(List<Discount> productDiscounts) {
        this.productDiscounts = productDiscounts;
    }
}
