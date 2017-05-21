package com.ip_b1.fii.admission.DTO;

public class CandidateInEntity {
    private AuthEntity auth;
    private String lastname;
    private String firstname;
    private String cnp;
    private String email;
    private String phone;

    public CandidateInEntity(AuthEntity auth, String cnp, String firstname, String lastname, String address, String phoneNumber) {
        this.auth = auth;
        this.cnp = cnp;
        this.firstname = firstname;
        this.lastname = lastname;
        this.phone = phoneNumber;
    }

    public CandidateInEntity(){

    }

    public AuthEntity getAuth() {
        return auth;
    }

    public void setAuth(AuthEntity auth) {
        this.auth = auth;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
