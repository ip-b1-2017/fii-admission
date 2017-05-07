package com.ip_b1.fii.admission.Controllers.DTO;

/**
 * Created by fenea on 5/7/2017.
 */
public class FormFieldEntity {
    String field;
    String value;
    public FormFieldEntity(String field, String value) {
        this.field = field;
        this.value = value;
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
