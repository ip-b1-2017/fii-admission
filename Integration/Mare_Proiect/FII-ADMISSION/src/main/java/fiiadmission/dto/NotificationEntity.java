package fiiadmission.dto;

public class NotificationEntity {
    private String message;
    private boolean read;

    public NotificationEntity(String message, boolean read) {
        this.message = message;
        this.read = read;
    }

    public NotificationEntity() {
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
