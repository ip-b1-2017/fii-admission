package fii.admission.note;

public class Note extends NoteDTO {
    private String candidatcnp;

    public Note(){

    }

    public String getCandidatCNP() {
        return candidatcnp;
    }

    public void setCandidatCNP(String candidatcnp) {
        this.candidatcnp = candidatcnp;
    }

}
