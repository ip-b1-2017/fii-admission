package com.ip_b1.fii.admission.Controllers.Utils;

import com.ip_b1.fii.admission.Controllers.DTO.AuthEntity;
import com.ip_b1.fii.admission.Controllers.DTO.UserEntity;
import com.ip_b1.fii.admission.ServerProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;


public class AuthUtils {
    public static boolean checkAuth(AuthEntity auth) {
        RestTemplate template = new RestTemplate();

        ResponseEntity<UserEntity> entity = template.getForEntity(
                ServerProperties.modelUrl + "/get_user?username={username}",
                UserEntity.class,
                auth.getUsername()
        );
        return entity.getStatusCode() != HttpStatus.NOT_FOUND && entity.getBody().getToken().equals(auth.getToken());
    }
}
