package com.ip_b1.fii.admission.DTO;

public class LoginTestOutEntity {
    private boolean success;
    private String token;
    private String failureReason;


    public LoginTestOutEntity(boolean success, String token, String failureReason) {
        this.success = success;
        this.token = token;
        this.failureReason = failureReason;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getFailureReason() {
        return failureReason;
    }

    public void setFailureReason(String failureReason) {
        this.failureReason = failureReason;
    }

    public LoginTestOutEntity() {
    }
}
