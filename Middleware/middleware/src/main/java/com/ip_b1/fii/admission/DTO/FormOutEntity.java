package com.ip_b1.fii.admission.DTO;

import java.util.ArrayList;
import java.util.List;

public class FormOutEntity {
    private List<FormFieldEntity> fields;

    public FormOutEntity() {
        fields = new ArrayList<>();
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
    public boolean isEmpty(){
        return fields.isEmpty();
    }
}
