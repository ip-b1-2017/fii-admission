package fiiadmission.dto;

/**
 * Created by rusub on 5/8/2017.
 */
public class SessionIdentifier {

    private boolean succes;
    private String token;
    private String failureReason;
    public SessionIdentifier(){

    }
    public boolean isSucces() {
        return succes;
    }

    public void setSucces(boolean succes) {
        this.succes = succes;
    }

    public String getFailureReason() {
        return failureReason;
    }

    public void setFailureReason(String failureReason) {
        this.failureReason = failureReason;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
