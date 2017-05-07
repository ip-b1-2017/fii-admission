package com.ip_b1.fii.admission.DTO;

public class ContestationEntity {
    private String contestation;
    private AuthEntity auth;

    public ContestationEntity() {
    }

    public String getContestation() {
        return contestation;
    }

    public void setContestation(String contestation) {
        this.contestation = contestation;
    }

    public AuthEntity getAuth() {
        return auth;
    }

    public void setAuth(AuthEntity auth) {
        this.auth = auth;
    }

    public ContestationEntity(String contestation, AuthEntity auth) {
        this.contestation = contestation;
        this.auth = auth;
    }
}
