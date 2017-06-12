package com.ip_b1.fii.admission.DTO;

/**
 * Created by rusub on 6/12/2017.
 */
public class GradeDTO extends GradeEntity {

    private String candidatcnp;

    public GradeDTO(){

    }

    public String getCandidatCNP() {
        return candidatcnp;
    }

    public void setCandidatCNP(String candidatcnp) {
        this.candidatcnp = candidatcnp;
    }
}
