package fii.admission.forms;

public class Form {
    private String informatii;
    private String status;
    private String candidatcnp;

    public String getInformatii() {
        return informatii;
    }

    public void setInformatii(String informatii) {
        this.informatii = informatii;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCandidatCnp() {
        return candidatcnp;
    }

    public void setCandidatCnp(String candidatcnp) {
        this.candidatcnp = candidatcnp;
    }

    @Override
    public String toString() {
        return "Form{" +
                "informatii='" + informatii + '\'' +
                ", status='" + status + '\'' +
                ", candidatcnp='" + candidatcnp + '\'' +
                '}';
    }
}
