package com.example.dfcommerce.services;

import com.example.dfcommerce.models.Merchant;
import com.example.dfcommerce.repositories.IMerchantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MerchantService implements UserDetailsService {
    @Autowired
    IMerchantRepository merchantRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Merchant merchant = merchantRepository.findByEmail(email);
        return merchant;
    }

    public Merchant addUser (Merchant merchant){
        return merchantRepository.save(merchant);
    }
}
