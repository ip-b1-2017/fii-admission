package com.ip_b1.fii.admission.Controllers;

import com.ip_b1.fii.admission.DTO.RoleEntity;
import com.ip_b1.fii.admission.DTO.UserEntity;
import com.ip_b1.fii.admission.ServerProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.ResponseErrorHandler;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by cosmin on 5/15/2017.
 */
@RestController
@RequestMapping("/controller")
public class GetRole {

    @RequestMapping(value = "/get_role/{email}/", method = RequestMethod.GET)
    public ResponseEntity<RoleEntity> get_role(@PathVariable("email") String email) {

        RestTemplate restTemplate = new RestTemplate();
        System.out.println("email din getRole =" + email);
        restTemplate.setErrorHandler(new ResponseErrorHandler() {
            @Override
            public boolean hasError(ClientHttpResponse clientHttpResponse) throws IOException {
                return false;
            }

            @Override
            public void handleError(ClientHttpResponse clientHttpResponse) throws IOException {

            }
        });

        String emailB64 = new String(Base64.getEncoder().encode(email.getBytes()));
        ResponseEntity<UserEntity> user = restTemplate.getForEntity(ServerProperties.modelUrl + "/users/get_user/{emailB64}", UserEntity.class,emailB64);
        RoleEntity role = new RoleEntity();
        role.setRole(user.getBody().getRole());
        System.out.println(user.getBody().getRole());
        if (role.getRole() != null) {
            return new ResponseEntity<RoleEntity>(role, HttpStatus.OK);
        } else {
            return new ResponseEntity<RoleEntity>(role, HttpStatus.NOT_FOUND);
        }

    }
}
