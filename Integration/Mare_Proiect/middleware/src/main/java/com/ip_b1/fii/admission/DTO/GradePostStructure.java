package com.ip_b1.fii.admission.DTO;

/**
 * Created by rusub on 6/12/2017.
 */
public class GradePostStructure {

    AuthEntity entity;
    GradeEntity grade;

    public GradePostStructure(){

    }

    public AuthEntity getEntity() {
        return entity;
    }

    public void setEntity(AuthEntity entity) {
        this.entity = entity;
    }

    public GradeEntity getGrade() {
        return grade;
    }

    public void setGrade(GradeEntity grade) {
        this.grade = grade;
    }
}
