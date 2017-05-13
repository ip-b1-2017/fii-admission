package com.ip_b1.fii.admission.DTO;

public class ResultInEntity {

    private AuthEntity auth;
    private String email;
    private float result;

    public ResultInEntity() {
    }

    public AuthEntity getAuth() {
        return auth;
    }

    public void setAuth(AuthEntity auth) {
        this.auth = auth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public float getResult() {
        return result;
    }

    public void setResult(float result) {
        this.result = result;
    }
}
