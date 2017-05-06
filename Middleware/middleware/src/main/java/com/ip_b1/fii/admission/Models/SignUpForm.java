package com.ip_b1.fii.admission.Models;

import com.ip_b1.fii.admission.Controllers.Verify.*;

public class SignUpForm {

    String username;
    String password;
    String email;

    public SignUpForm(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }
    public int verify(){
        if(VerifyUsername.verify(this.username))
            return -1;
        if(VerifyPassword.verify(this.password))
            return -2;
        if(VerifyEmail.verify(this.email))
            return -3;
        return 1;
    }
}