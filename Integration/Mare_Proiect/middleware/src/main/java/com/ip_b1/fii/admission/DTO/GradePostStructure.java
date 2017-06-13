package com.ip_b1.fii.admission.DTO;

/**
 * Created by rusub on 6/12/2017.
 */
public class GradePostStructure {

    AuthEntity entity;
    GradeDTO mark;

    public GradePostStructure(){

    }

    public AuthEntity getEntity() {
        return entity;
    }

    public void setEntity(AuthEntity entity) {
        this.entity = entity;
    }

    public GradeDTO getMark() {
        return mark;
    }

    public GradeEntity getGradeEntity(){return (GradeEntity)mark;}

    public void setMark(GradeDTO grade) {
        this.mark = grade;
    }
}
