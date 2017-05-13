package fiiadmission.view.Model;

/**
 * Created by cosmin on 5/13/2017.
 */
public class SignUpResponse {

    private boolean success;
    private String failureReason;
    public SignUpResponse(){

    }
    public SignUpResponse(boolean success, String failureReason) {
        this.success = success;
        this.failureReason = failureReason;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getFailureReason() {
        return failureReason;
    }

    public void setFailureReason(String failureReason) {
        this.failureReason = failureReason;
    }
}

