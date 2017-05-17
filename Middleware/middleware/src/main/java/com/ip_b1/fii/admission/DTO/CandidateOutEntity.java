package com.ip_b1.fii.admission.DTO;

public class CandidateOutEntity {
    private String email;
    private String cnp;
    private String firstname;
    private String lastname;
    private String address;
    private String phoneNumber;

    public CandidateOutEntity(String email, String cnp, String firstname, String lastname, String address, String phoneNumber) {
        this.email = email;
        this.cnp = cnp;
        this.firstname = firstname;
        this.lastname = lastname;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public CandidateOutEntity(CandidateInEntity entity){
        this.email = entity.getAuth().getEmail();
        this.cnp = entity.getCnp();
        this.firstname = entity.getFirstname();
        this.lastname = entity.getLastname();
        this.address = entity.getAddress();
        this.phoneNumber = entity.getPhoneNumber();
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
