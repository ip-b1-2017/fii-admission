package com.ip_b1.fii.admission.DTO;

public class FormFieldEntity {
    private String field;
    private String value;
    public FormFieldEntity(String field, String value) {
        this.field = field;
        this.value = value;
    }

    public FormFieldEntity() {
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
