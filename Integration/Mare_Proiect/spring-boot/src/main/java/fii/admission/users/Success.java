package fii.admission.users;

public class Success {
    private boolean success;

    public Success(){

    }
    public Success(boolean success) {
        this.success = success;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
