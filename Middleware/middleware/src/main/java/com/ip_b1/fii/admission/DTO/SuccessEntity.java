package com.ip_b1.fii.admission.DTO;

public class SuccessEntity {
    private boolean success;

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
