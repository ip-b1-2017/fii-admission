package com.ip_b1.fii.admission.DTO;

import java.util.List;

/**
 * Created by fenea on 5/7/2017.
 */
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
}
