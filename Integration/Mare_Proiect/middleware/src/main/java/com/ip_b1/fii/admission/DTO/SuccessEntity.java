package com.ip_b1.fii.admission.DTO;

public class SuccessEntity {
    private boolean success;
    private String failureReason;



    public SuccessEntity() {

    }
    public String getFailureReason() {
        return failureReason;
    }

    public void setFailureReason(String failureReason) {
        this.failureReason = failureReason;
    }
    public SuccessEntity(boolean success) {
        this.success = success;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
