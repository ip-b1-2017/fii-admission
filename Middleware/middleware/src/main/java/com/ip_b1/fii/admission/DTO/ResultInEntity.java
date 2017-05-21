package com.ip_b1.fii.admission.DTO;

public class ResultInEntity {

    private AuthEntity auth;
    private Note note;

    public ResultInEntity() {
    }

    public AuthEntity getAuth() {
        return auth;
    }

    public void setAuth(AuthEntity auth) {
        this.auth = auth;
    }

    public Note getNote() {
        return note;
    }

    public void setNote(Note note) {
        this.note = note;
    }
}
