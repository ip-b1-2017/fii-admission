package com.ip_b1.fii.admission.DTO;

import java.util.List;

public class ApplicationsEntity {
    List<String> applications;

    public ApplicationsEntity() {

    }

    public List<String> getApplications() {
        return applications;
    }

    public void setApplications(List<String> applications) {
        this.applications = applications;
    }
    public boolean isEmpty(){
        return applications.isEmpty();
    }
}
