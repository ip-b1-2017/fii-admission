package com.ip_b1.fii.admission.DTO;

public class NotificationsOutEntity {

    private String notification;

    public NotificationsOutEntity(String notification) {
        this.notification = notification;
    }

    public NotificationsOutEntity() {
    }

    public String getNotification() {
        return notification;
    }

    public void setNotification(String notification) {
        this.notification = notification;
    }
}
