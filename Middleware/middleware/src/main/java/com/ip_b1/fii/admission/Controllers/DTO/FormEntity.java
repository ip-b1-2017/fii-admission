package com.ip_b1.fii.admission.Controllers.DTO;

import java.util.List;

/**
 * Created by fenea on 5/7/2017.
 */
public class FormEntity {
    AuthEntity auth;
    List<FormFieldEntity> fields;

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
