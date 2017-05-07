package com.ip_b1.fii.admission.DTO;

public class NotificationEntity {

    private String email;
    private boolean seen;
    private String message;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isSeen() {
        return seen;
    }

    public void setSeen(boolean seen) {
        this.seen = seen;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public NotificationEntity(String email, boolean seen, String message) {

        this.email = email;
        this.seen = seen;
        this.message = message;
    }
}
