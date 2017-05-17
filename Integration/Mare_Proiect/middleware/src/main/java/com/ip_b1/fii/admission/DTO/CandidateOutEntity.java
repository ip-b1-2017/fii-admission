package com.ip_b1.fii.admission.DTO;

public class CandidateOutEntity {
    private String email;
    private String cnp;
    private String firstname;
    private String lastname;
    private String phone;

    public CandidateOutEntity() {
    }

    public CandidateOutEntity(String email, String cnp, String firstname, String lastname, String phoneNumber) {
        this.email = email;
        this.cnp = cnp;
        this.firstname = firstname;
        this.lastname = lastname;
        this.phone = phoneNumber;
    }

    public CandidateOutEntity(CandidateInEntity entity) {
        this.email = entity.getAuth().getUsername();
        this.cnp = entity.getCnp();
        this.firstname = entity.getFirstname();
        this.lastname = entity.getLastname();
        this.phone = entity.getPhoneNumber();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCnp() {
        return cnp;
    }

    public void setCnp(String cnp) {
        this.cnp = cnp;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
