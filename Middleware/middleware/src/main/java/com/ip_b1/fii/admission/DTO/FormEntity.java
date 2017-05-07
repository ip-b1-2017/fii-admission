package com.ip_b1.fii.admission.Controllers.DTO;

import java.util.List;

public class FormEntity {
    private AuthEntity auth;
    private List<FormFieldEntity> fields;

    public FormEntity() {
    }

    public FormEntity(AuthEntity auth, List<FormFieldEntity> fields) {
        this.auth = auth;
        this.fields = fields;
    }

    public AuthEntity getAuth() {
        return auth;
    }

    public void setAuth(AuthEntity auth) {
        this.auth = auth;
    }

    public List<FormFieldEntity> getFields() {
        return fields;
    }

    public void setFields(List<FormFieldEntity> fields) {
        this.fields = fields;
    }
}
