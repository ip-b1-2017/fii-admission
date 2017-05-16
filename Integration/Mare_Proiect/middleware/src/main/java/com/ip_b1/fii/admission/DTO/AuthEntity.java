package com.ip_b1.fii.admission.DTO;

public class AuthEntity {
    private String username;
    private String token;

    public AuthEntity(String username, String token) {
        this.username = username;
        this.token = token;
    }

    public AuthEntity() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

}