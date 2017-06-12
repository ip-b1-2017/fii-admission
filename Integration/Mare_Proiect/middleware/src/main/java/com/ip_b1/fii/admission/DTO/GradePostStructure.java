package com.ip_b1.fii.admission.DTO;

/**
 * Created by rusub on 6/12/2017.
 */
public class GradePostStructure {

    AuthEntity entity;
    GradeDTO grade;

    public GradePostStructure(){

    }

    public AuthEntity getEntity() {
        return entity;
    }

    public void setEntity(AuthEntity entity) {
        this.entity = entity;
    }

    public GradeDTO getGrade() {
        return grade;
    }

    public GradeEntity getGradeEntity(){return (GradeEntity)grade;}

    public void setGrade(GradeDTO grade) {
        this.grade = grade;
    }
}
