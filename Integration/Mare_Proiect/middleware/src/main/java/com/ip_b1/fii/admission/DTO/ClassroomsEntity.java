package com.ip_b1.fii.admission.DTO;

public class ClassroomsEntity {
    private String id;
    private String locatie;
    private int nr_locuri;

    public ClassroomsEntity() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLocatie() {
        return locatie;
    }

    public void setLocatie(String locatie) {
        this.locatie = locatie;
    }

    public int getNrLocuri() {
        return nr_locuri;
    }

    public void setNrLocuri(int nr_locuri) {
        this.nr_locuri = nr_locuri;
    }

}
