package com.ip_b1.fii.admission.DTO;

public class FormStatusEntity {

    private String CNP;
    private String status;

    public FormStatusEntity(String CNP, String status) {
        this.CNP = CNP;
        this.status = status;
    }

    public String getCNP() {
        return CNP;
    }

    public void setCNP(String CNP) {
        this.CNP = CNP;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
