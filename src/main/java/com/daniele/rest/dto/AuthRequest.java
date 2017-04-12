package com.daniele.rest.dto;

public class AuthRequest {
    private String email;
    private String password;

    public AuthRequest() {
    	// for JPA
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}