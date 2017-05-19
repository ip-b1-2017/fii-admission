package com.ip_b1.fii.admission.DTO;

public class User {
    private String role;
    private String email;
    private String password;
    private String token;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getParola() {
        return password;
    }

    public void setParola(String password) {
        this.password = password;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "email: " + email + " | rol: " + role + " | password: " + password + " | token: " + token;
    }
}