package com.ip_b1.fii.admission.DTO;

public class NotificationsOutEntity {

    private String notifications;

    public NotificationsOutEntity(String notifications) {
        this.notifications = notifications;
    }

    public NotificationsOutEntity() {
    }

    public String getNotifications() {
        return notifications;
    }

    public void setNotifications(String notifications) {
        this.notifications = notifications;
    }
}
