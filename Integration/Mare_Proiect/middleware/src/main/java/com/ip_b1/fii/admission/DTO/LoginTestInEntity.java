package com.ip_b1.fii.admission.DTO;

public class LoginTestInEntity {
    private String email;
    private String pswall;

    public LoginTestInEntity() {

    }

    public String getUsername() {
        return email;
    }

    public void setUsername(String username) {
        this.email = username;
    }

    public String getPassword() {
        return pswall;
    }

    public void setPassword(String password) {
        this.pswall = password;
    }
}
