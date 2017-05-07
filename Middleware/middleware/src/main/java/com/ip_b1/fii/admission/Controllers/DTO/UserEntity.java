package com.ip_b1.fii.admission.Controllers.DTO;

public class UserEntity {
    private String email;
    private String token;
    private String passwordHash;
    private String role;

    public UserEntity(String email, String token, String passwordHash, String role) {
        this.email = email;
        this.token = token;
        this.passwordHash = passwordHash;
        this.role = role;
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

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
