package com.ip_b1.fii.admission.Utils;

import com.ip_b1.fii.admission.DTO.AuthEntity;
import com.ip_b1.fii.admission.DTO.UserEntity;
import com.ip_b1.fii.admission.ServerProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Base64;


public class AuthUtils {
    public static boolean claimsAuthenticated(AuthEntity auth) {
        return auth.getUsername() != null && auth.getToken() != null;
    }

    public static boolean checkAuth(AuthEntity auth) {
        System.out.println(auth);
        if (auth == null || auth.getUsername() == null || auth.getToken() == null) {
            return false;
        }

        RestTemplate template = new RestTemplate();

        try {
            String emailB64 = new String(Base64.getEncoder().encode(auth.getUsername().getBytes()));
            System.out.println(emailB64);
            ResponseEntity<UserEntity> entity = template.getForEntity(
                    ServerProperties.modelUrl + "/users/get_user/{email}",
                    UserEntity.class,
                    emailB64
            );
            System.out.println(entity);
            return entity.getStatusCode() == HttpStatus.OK && entity.getBody().getToken().equals(auth.getToken());
        }
        catch (RestClientException ex){
            System.out.println("Auth not found! " + ex.toString());
            return false;
        }
    }

    public static boolean checkAuthIsAdmin(AuthEntity auth) {
        RestTemplate template = new RestTemplate();

        ResponseEntity<UserEntity> entity = template.getForEntity(
                ServerProperties.modelUrl + "/get_user?username={username}",
                UserEntity.class,
                auth.getUsername()
        );
        return entity.getStatusCode() != HttpStatus.NOT_FOUND &&
                entity.getBody().getToken().equals(auth.getToken()) &&
                entity.getBody().getRole().equals("admin");
    }
}
