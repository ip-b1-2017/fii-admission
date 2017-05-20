package fii.admission.candidati_forms;

import fii.admission.candidati.Candidat;
import fii.admission.forms.Form;

/**
 * Created by andy on 16.05.2017.
 */
public class CandidatForm {
    private Candidat candidate;
    private Form form;

    public Candidat getCandidate() {
        return candidate;
    }

    public void setCandidate(Candidat candidate) {
        this.candidate = candidate;
    }

    public Form getForm() {
        return form;
    }

    public void setForm(Form form) {
        this.form = form;
    }
}
