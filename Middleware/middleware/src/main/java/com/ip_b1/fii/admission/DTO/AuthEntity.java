package com.ip_b1.fii.admission.DTO;

public class AuthEntity {
    private String email;
    private String token;

    public AuthEntity(String username, String token) {
        this.email = username;
        this.token = token;
    }

    public AuthEntity() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

}