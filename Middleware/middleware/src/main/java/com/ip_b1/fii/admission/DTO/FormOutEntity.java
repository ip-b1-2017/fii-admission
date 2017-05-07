package com.ip_b1.fii.admission.Controllers.DTO;

import java.util.List;

public class FormOutEntity {
    private List<FormFieldEntity> fields;

    public FormOutEntity() {
    }

    public FormOutEntity(List<FormFieldEntity> fields) {
        this.fields = fields;
    }

    public List<FormFieldEntity> getFields() {
        return fields;
    }

    public void setFields(List<FormFieldEntity> fields) {
        this.fields = fields;
    }
}
