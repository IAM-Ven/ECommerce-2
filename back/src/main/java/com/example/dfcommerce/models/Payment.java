package com.example.dfcommerce.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name="payment_options")
public class Payment {
    @Id
    @GeneratedValue
    @Column(name="id")
    int id;

    @Column(name="payment_type")
    String paymentType;

    @Column(name="payment_duration")
    int duration;

    @Column(name="interest_rate")
    int interestRate;

    @ManyToMany(mappedBy = "paymentMethods")
    Collection<Product> productList = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(int interestRate) {
        this.interestRate = interestRate;
    }

    public void setProductList(Collection<Product> productList) {
        this.productList = productList;
    }
}
