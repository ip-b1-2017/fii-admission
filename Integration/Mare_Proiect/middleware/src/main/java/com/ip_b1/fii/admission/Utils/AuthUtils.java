package com.ip_b1.fii.admission.Utils;

import com.ip_b1.fii.admission.DTO.AuthEntity;
import com.ip_b1.fii.admission.DTO.UserEntity;
import com.ip_b1.fii.admission.ServerProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;


public class AuthUtils {
    public static boolean claimsAuthenticated(AuthEntity auth){
        return auth.getUsername() != null && auth.getToken() != null;
    }

    public static boolean checkAuth(AuthEntity auth) {
        if (auth.getUsername() == null || auth.getToken() == null){
            return false;
        }

        RestTemplate template = new RestTemplate();

        ResponseEntity<UserEntity> entity = template.getForEntity(
                ServerProperties.modelUrl + "/get_user?username={username}",
                UserEntity.class,
                auth.getUsername()
        );
        return entity.getStatusCode() != HttpStatus.NOT_FOUND && entity.getBody().getToken().equals(auth.getToken());
    }

    public static boolean checkAuthIsAdmin(AuthEntity auth){
        RestTemplate template = new RestTemplate();

        ResponseEntity<UserEntity> entity = template.getForEntity(
                ServerProperties.modelUrl + "/get_user?username={username}",
                UserEntity.class,
                auth.getUsername()
        );
        return entity.getStatusCode() != HttpStatus.NOT_FOUND &&
                entity.getBody().getToken().equals(auth.getToken()) &&
                entity.getBody().getRol().equals("admin");
    }
}
