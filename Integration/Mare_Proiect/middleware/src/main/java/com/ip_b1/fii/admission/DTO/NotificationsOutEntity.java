package com.ip_b1.fii.admission.DTO;

public class NotificationsOutEntity {
    private String message;
    private boolean read;

    public NotificationsOutEntity(String message, boolean read) {
        this.message = message;
        this.read = read;
    }

    public NotificationsOutEntity() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isRead() {
        return read;
    }

    public void setRead(boolean read) {
        this.read = read;
    }
}
