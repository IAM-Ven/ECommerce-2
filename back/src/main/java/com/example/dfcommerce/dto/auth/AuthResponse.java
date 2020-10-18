package com.example.dfcommerce.dto.auth;

import java.io.Serializable;

public class AuthResponse implements Serializable {

    private static final long serialVersionUID = -8091879091924046844L;

    private final String jwt;

    public AuthResponse(String jwt) {
        this.jwt = jwt;
    }

    public String getToken() {
        return this.jwt;
    }
}
