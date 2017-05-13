package com.ip_b1.fii.admission.DTO;

public class SignUpTestInEntity {
    private String password;
    private String email;

    public SignUpTestInEntity(){

    }

    public SignUpTestInEntity( String email, String password) {

        this.email = email;
        this.password = password;

    }
    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
