package com.ip_b1.fii.admission.Controllers.DTO;

import java.util.List;

/**
 * Created by fenea on 5/7/2017.
 */
public class FormOutEntity {
    List<FormFieldEntity> fields;

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
