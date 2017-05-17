package com.ip_b1.fii.admission.Utils;

import com.ip_b1.fii.admission.DTO.AuthEntity;
import com.ip_b1.fii.admission.DTO.Email;
import com.ip_b1.fii.admission.DTO.User;
import com.ip_b1.fii.admission.ServerProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.ResponseErrorHandler;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

@RestController
@RequestMapping("/auth")
public class AuthUtils {
    public static boolean claimsAuthenticated(AuthEntity auth) {
        return auth.getEmail() != null && auth.getToken() != null;
    }

    @RequestMapping(value = "/checkAuth", method = RequestMethod.POST)
    public static boolean checkAuth(@RequestBody AuthEntity auth) {
        if (auth.getEmail() == null || auth.getToken() == null) {
            return false;
        }

        RestTemplate template = new RestTemplate();

        template.setErrorHandler(new ResponseErrorHandler() {
            @Override
            public boolean hasError(ClientHttpResponse clientHttpResponse) throws IOException {
                return false;
            }

            @Override
            public void handleError(ClientHttpResponse clientHttpResponse) throws IOException {
            }
        });

        Email email = new Email();
        email.setEmail(auth.getEmail());

        ResponseEntity<User> entity = template.postForEntity(
                ServerProperties.modelUrl + "/users/get_user",
                email,
                User.class
        );
        if (entity.getStatusCode() != HttpStatus.NOT_FOUND)
            if (entity.getBody().getToken().equals(auth.getToken())) return true;
        return false;
    }

    @RequestMapping(value = "/checkAuthIsAdmin", method = RequestMethod.POST)
    public static boolean checkAuthIsAdmin(@RequestBody AuthEntity auth) {
        RestTemplate template = new RestTemplate();

        template.setErrorHandler(new ResponseErrorHandler() {
            @Override
            public boolean hasError(ClientHttpResponse clientHttpResponse) throws IOException {
                return false;
            }

            @Override
            public void handleError(ClientHttpResponse clientHttpResponse) throws IOException {
            }
        });

        Email email = new Email();
        email.setEmail(auth.getEmail());

        ResponseEntity<User> entity = template.postForEntity(
                ServerProperties.modelUrl + "users/get_user",
                email,
                User.class
        );
        return entity.getStatusCode() != HttpStatus.NOT_FOUND &&
                entity.getBody().getToken().equals(auth.getToken()) &&
                entity.getBody().getRol().equals("admin");
    }
}
