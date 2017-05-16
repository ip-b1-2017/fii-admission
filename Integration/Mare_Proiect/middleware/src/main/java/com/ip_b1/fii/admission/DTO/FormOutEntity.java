package com.ip_b1.fii.admission.DTO;

import java.util.List;
import java.util.Map;

public class FormOutEntity {
    private String fields;
    private String candidateCnp;
    private String status;

    public FormOutEntity(String fields, String candidateCnp, String status) {
        this.fields = fields;
        this.candidateCnp = candidateCnp;
        this.status = status;
    }

    public String getCandidateCnp() {
        return candidateCnp;
    }

    public void setCandidateCnp(String candidateCnp) {
        this.candidateCnp = candidateCnp;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getFields() {
        return fields;
    }

    public void setFields(String fields) {
        this.fields = fields;
    }
}
