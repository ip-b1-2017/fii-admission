package com.ip_b1.fii.admission.DTO;

public class UserEntity {
    private String rol;
    private String email;
    private String password;
    private String token;

    public UserEntity(){

    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
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