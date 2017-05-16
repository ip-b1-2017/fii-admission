package fii.admission.sali_examen_candidat;

public class Sali_Examen_Candidat {
    private String candidatcnp;
    private String sali_examensaliid;
    private String sali_examenexamenid;

    public String getCandidatCNP() {
        return candidatcnp;
    }

    public void setCandidatCNP(String CNP) {
        this.candidatcnp = CNP;
    }

    public String getSaliExamenSaliId() {
        return sali_examensaliid;
    }

    public void setSaliExamenSaliId(String sali_examensaliid) {
        this.sali_examensaliid = sali_examensaliid;
    }

    public String getSaliExamenExamenId() {
        return sali_examenexamenid;
    }

    public void setSaliExamenExamenId(String sali_examenexamenid) {
        this.sali_examenexamenid = sali_examenexamenid;
    }
}
