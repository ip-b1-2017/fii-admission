package com.ip_b1.fii.admission.DTO;

public class UserEntity {
    private String role;
    private String email;
    private String password;
    private String token;

    public UserEntity(){

    }

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

    public void setParola(String parola) {
        this.password = parola;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}