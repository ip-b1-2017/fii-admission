package fii.admission.users;

public class SetTokenEntity {
    private String email;
    private String token;

    public SetTokenEntity() {

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String username) {
        this.email = username;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
