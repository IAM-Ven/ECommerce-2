package com.example.dfcommerce.repositories;

import com.example.dfcommerce.models.Merchant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMerchantRepository extends JpaRepository<Merchant, Integer> {
    public Merchant findByEmail(String email);
}
