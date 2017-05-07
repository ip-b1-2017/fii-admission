package com.ip_b1.fii.admission.Controllers.DTO;

/**
 * Created by fenea on 5/7/2017.
 */
public class SaveFormOutEntity {


    private boolean success;
    private String failureReason;

    public SaveFormOutEntity(boolean success, String failureReason) {
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
