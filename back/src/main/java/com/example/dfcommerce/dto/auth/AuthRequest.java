package com.example.dfcommerce.dto.auth;

import java.io.Serializable;

public class AuthRequest implements Serializable {

    private static final long serialVersionUID = 5926468583005150707L;

    private String email;
    private String password;
    private boolean remember=false;

    //need default constructor for JSON Parsing
    public AuthRequest()
    {

    }

    public AuthRequest(String email, String password) {
        this.setemail(email);
        this.setPassword(password);
    }

    public AuthRequest(String email, String password, boolean remember) {
        this.setemail(email);
        this.setPassword(password);
        this.remember = remember;
    }
    public String getemail() {
        return this.email;
    }
    public void setemail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return this.password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isRemember() {
        return remember;
    }

    public void setRemember(boolean remember) {
        this.remember = remember;
    }

}
