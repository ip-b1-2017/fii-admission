package fii.admission.notificari;

public class Notificari {
    private String message;
    private boolean seen;
    private String email;

    public Notificari(String message, boolean seen, String email) {
        this.message = message;
        this.seen = seen;
        this.email = email;
    }

    public Notificari() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSeen() {
        return seen;
    }

    public void setSeen(boolean seen) {
        this.seen = seen;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
