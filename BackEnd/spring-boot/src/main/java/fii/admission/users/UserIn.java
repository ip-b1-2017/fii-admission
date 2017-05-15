
package fii.admission.users;

public class UserIn {
    private String email;
    private String pswall;

    public UserIn() {
    }

    public UserIn(String username, String password) {
        this.email = username;
        this.pswall = password;
    }

    public String getUsername() {
        return email;
    }

    public void setUsername(String username) {
        this.email = username;
    }

    public String getPassword() {
        return pswall;
    }

    public void setPassword(String password) {
        this.pswall = password;
    }
}
