package com.ip_b1.fii.admission.ModelStubs;

import com.ip_b1.fii.admission.DTO.AuthEntity;
import com.ip_b1.fii.admission.DTO.Email;
import com.ip_b1.fii.admission.DTO.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Base64;

@RestController
@RequestMapping(value = "/users")
public class AuthUtilsStub {

    public static boolean claimsAuthenticated(AuthEntity auth) {
        return auth.getEmail() != null && auth.getToken() != null;
    }

    @RequestMapping(value = "/get_user/{emailB64}", method = RequestMethod.GET)
    public ResponseEntity<User> getUser(@PathVariable("emailB64") String email) {
        String emailB64 = new String(Base64.getDecoder().decode(email.getBytes()));
        System.out.println(emailB64);
        switch (emailB64){
            case "admin@info.uaic.ro":
                User u = new User();
                u.setEmail("admin@info.uaic.ro");
                u.setParola("somepass");
                u.setRole("admin");
                u.setToken("topkek");
                return new ResponseEntity<>(u, HttpStatus.OK);
            case "alexd@info.uaic.ro":
                User u2 = new User();
                u2.setEmail(emailB64);
                u2.setParola("anotherpass");
                u2.setRole("user");
                u2.setToken("meme");
                return new ResponseEntity<>(u2, HttpStatus.OK);
            default:
                return new ResponseEntity<>(new User(), HttpStatus.NOT_FOUND);
        }
    }
}
