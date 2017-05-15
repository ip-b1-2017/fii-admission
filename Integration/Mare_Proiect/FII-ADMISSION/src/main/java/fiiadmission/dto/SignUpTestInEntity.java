package fiiadmission.dto;

/**
 * Created by cosmin on 5/15/2017.
 */

    public class SignUpTestInEntity {
        private String email;
        private String pswall;


        public SignUpTestInEntity(){

        }

        public String getEmail() {
            return email;
        }

        public String getPswall() {
            return pswall;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public void setPswall(String password) {
            this.pswall = password;
        }
    }

