package fii.admission.notificari;

public class Notificari {
    private String message;
    private boolean seen;
    private String email;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean getSeen() {
        return seen;
    }

    public void setSeen(boolean seen) {
        this.seen = seen;
    }

    public String getUserEmail() {
        return email;
    }

    public void setUserEmail(String useremail) {
        this.email = useremail;
    }
}
