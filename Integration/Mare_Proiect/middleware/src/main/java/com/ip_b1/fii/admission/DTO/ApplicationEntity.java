package com.ip_b1.fii.admission.DTO;

import java.util.List;

public class ApplicationEntity {
    private CandidateOutEntity candidate;
    private FormOutEntity form;

    public ApplicationEntity() {
    }

    public ApplicationEntity(CandidateOutEntity candidate, FormOutEntity form) {
        this.candidate = candidate;
        this.form = form;
    }

    public CandidateOutEntity getCandidate() {
        return candidate;
    }

    public void setCandidate(CandidateOutEntity candidate) {
        this.candidate = candidate;
    }

    public FormOutEntity getForm() {
        return form;
    }

    public void setForm(FormOutEntity form) {
        this.form = form;
    }
}
