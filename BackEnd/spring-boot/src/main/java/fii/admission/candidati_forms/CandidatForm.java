package fii.admission.candidati_forms;

import fii.admission.candidati.Candidat;
import fii.admission.forms.Form;

/**
 * Created by andy on 16.05.2017.
 */
public class CandidatForm {
    private Candidat candidat;
    private Form form;

    public Candidat getCandidat() {
        return candidat;
    }

    public void setCandidat(Candidat candidat) {
        this.candidat = candidat;
    }

    public Form getForm() {
        return form;
    }

    public void setForm(Form form) {
        this.form = form;
    }
}
