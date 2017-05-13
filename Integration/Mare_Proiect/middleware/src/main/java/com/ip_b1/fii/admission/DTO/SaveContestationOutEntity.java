package com.ip_b1.fii.admission.DTO;

public class SaveContestationOutEntity {

    private boolean success;
    private String failureReason;

    public SaveContestationOutEntity() {
    }

    public SaveContestationOutEntity(boolean success, String failureReason) {
        this.success = success;
        this.failureReason = failureReason;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getFailureReason() {
        return failureReason;
    }

    public void setFailureReason(String failureReason) {
        this.failureReason = failureReason;
    }
}
