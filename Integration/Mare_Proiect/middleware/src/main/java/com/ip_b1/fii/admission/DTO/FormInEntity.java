package com.ip_b1.fii.admission.DTO;

import java.util.Map;

public class FormInEntity {
    private com.ip_b1.fii.admission.DTO.AuthEntity auth;
    private Map<String, String> fields;

    public FormInEntity() {
    }

    public FormInEntity(AuthEntity auth, Map<String, String> fields) {
        this.auth = auth;
        this.fields = fields;
    }

    public AuthEntity getAuth() {
        return auth;
    }

    public void setAuth(AuthEntity auth) {
        this.auth = auth;
    }

    public Map<String, String> getFields() {
        return fields;
    }

    public void setFields(Map<String, String> fields) {
        this.fields = fields;
    }
}
