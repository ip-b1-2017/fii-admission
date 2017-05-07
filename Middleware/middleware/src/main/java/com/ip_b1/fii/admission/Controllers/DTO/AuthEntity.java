package com.ip_b1.fii.admission.Controllers.DTO;

/**
 * Created by fenea on 5/7/2017.
 */
public class AuthEntity {


    String username;
    String token;

    public AuthEntity(){

    }
    public String getUsername() {
        return username;
    }

    public String getToken() {
        return token;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setToken(String token) {
        this.token = token;
    }
    public AuthEntity(String username, String token) {
        this.username = username;
        this.token = token;
    }

}
