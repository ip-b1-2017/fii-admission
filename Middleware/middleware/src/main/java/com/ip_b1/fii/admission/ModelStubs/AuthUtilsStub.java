package com.ip_b1.fii.admission.ModelStubs;

import com.ip_b1.fii.admission.DTO.AuthEntity;
import com.ip_b1.fii.admission.DTO.Email;
import com.ip_b1.fii.admission.DTO.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class AuthUtilsStub {

    public static boolean claimsAuthenticated(AuthEntity auth) {
        return auth.getEmail() != null && auth.getToken() != null;
    }

    @RequestMapping(value = "/get_user", method = RequestMethod.POST)
    public ResponseEntity<User> checkAuth(@RequestBody Email email) {
        switch (email.getEmail()){
            case "admin@info.uaic.ro":
                User u = new User();
                u.setEmail("admin@info.uaic.ro");
                u.setParola("somepass");
                u.setRol("admin");
                u.setToken("topkek");
                return new ResponseEntity<>(u, HttpStatus.OK);
            default:
                return new ResponseEntity<>(new User(), HttpStatus.NOT_FOUND);
        }
    }
}
