package com.ip_b1.fii.admission.DTO;

public class Candidat {
    private String lastname;
    private String firstname;
    private String cnp;
    private String email;
    private String phone;

    public Candidat() {

    }

    public Candidat(String email, String cnp, String firstname, String lastname, String address, String phoneNumber) {
        this.email = email;
        this.cnp = cnp;
        this.firstname = firstname;
        this.lastname = lastname;
        this.phone = phoneNumber;
    }

    public Candidat(CandidateInEntity entity) {
        this.email = entity.getAuth().getEmail();
        this.cnp = entity.getCnp();
        this.firstname = entity.getFirstname();
        this.lastname = entity.getLastname();
        this.phone = entity.getPhone();
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getCnp() {
        return cnp;
    }

    public void setCnp(String cnp) {
        this.cnp = cnp;
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

    @Override
    public String toString() {
        return "Candidat{" +
                "lastname='" + lastname + '\'' +
                ", firstname='" + firstname + '\'' +
                ", cnp='" + cnp + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
