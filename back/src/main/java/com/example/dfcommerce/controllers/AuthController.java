package com.example.dfcommerce.controllers;

import com.example.dfcommerce.authentication.JwtAuthManager;
import com.example.dfcommerce.dto.auth.AuthRequest;
import com.example.dfcommerce.dto.auth.AuthResponse;
import com.example.dfcommerce.models.Merchant;
import com.example.dfcommerce.services.MerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtAuthManager jwtAuthManager;

    @Autowired
    private MerchantService merchantService;

    @PostMapping("/auth")
    public ResponseEntity<?> getJWT(@RequestBody AuthRequest request) throws Exception {
        authenticate(request.getemail(), request.getPassword());

        if(request.getPassword().length()>=6){
            final UserDetails userDetails = merchantService
                    .loadUserByUsername(request.getemail());

            if(request.isRemember()){
                jwtAuthManager.JWT_TOKEN_VALIDITY = 24 * 7 * 60 * 60;
            }

            final String token = jwtAuthManager.generateToken(userDetails);

            return ResponseEntity.ok(new AuthResponse(token));
        }
        else{
            return (ResponseEntity<?>) ResponseEntity.status(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/signup")
    public Merchant saveUser(@RequestBody Merchant merchant) throws Exception {
        return merchantService.addUser(merchant);
    }

    private void authenticate(String email, String password) throws Exception{
        try{
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email,password));
        }
        catch (DisabledException e){
            throw new Exception("USER_DISABLED", e);
        }
        catch (BadCredentialsException e){
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }
}
