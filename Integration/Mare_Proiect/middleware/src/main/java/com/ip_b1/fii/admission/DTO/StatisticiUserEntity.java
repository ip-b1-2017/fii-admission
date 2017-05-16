package com.ip_b1.fii.admission.DTO;

/**
 * Created by cosmin on 5/16/2017.
 */
public class StatisticiUserEntity {
    String statusAplicatie;
    String numarAplicanti;
    public StatisticiUserEntity(){

    }
    public String getStatusAplicatie() {
        return statusAplicatie;
    }

    public void setStatusAplicatie(String statusAplicatie) {
        this.statusAplicatie = statusAplicatie;
    }

    public String getNumarAplicanti() {
        return numarAplicanti;
    }

    public void setNumarAplicanti(String numarAplicanti) {
        this.numarAplicanti = numarAplicanti;
    }

}