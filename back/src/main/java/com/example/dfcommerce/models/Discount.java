package com.example.dfcommerce.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

@Entity
@Table(name = "discounts")
public class Discount {

    @Id
    @GeneratedValue
    @Column(name = "id")
    int id;

    @Column(name = "percentage")
    int percentage;

    @Column(name = "start_Date")
    Date startDate;

    @Column(name="end_Date")
    Date endDate;

    @ManyToMany(mappedBy = "productDiscounts")
    Collection<Product> product = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPercentage() {
        return percentage;
    }

    public void setPercentage(int percentage) {
        this.percentage = percentage;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public void setProduct(Collection<Product> product) {
        this.product = product;
    }
}
