package fii.admission.forms;

public class Form {
    private String fields;
    private String status;
    private String candidateCnp;

    public String getFields() {
        return fields;
    }

    public void setFields(String fields) {
        this.fields = fields;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCandidateCnp() {
        return candidateCnp;
    }

    public void setCandidateCnp(String candidatcnp) {
        this.candidateCnp = candidatcnp;
    }

    @Override
    public String toString() {
        return "Form{" +
                "fields='" + fields + '\'' +
                ", status='" + status + '\'' +
                ", candidateCnp='" + candidateCnp + '\'' +
                '}';
    }
}
