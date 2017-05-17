package com.ip_b1.fii.admission.DTO;

public class ApplicationReview {

    private AuthEntity user;
    private String cnp;
    private String message;

    public AuthEntity getUser() {
        return user;
    }

    public void setUser(AuthEntity user) {
        this.user = user;
    }

    public String getCnp() {
        return cnp;
    }

    public void setCnp(String cnp) {
        this.cnp = cnp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
