package fii.admission.notificari;

public class Notificari {
    private String text;
    private boolean seen;
    private String email;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
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
