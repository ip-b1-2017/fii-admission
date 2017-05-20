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

/**
 * Created by cosmin on 5/15/2017.
 */
@RestController
@RequestMapping("/controller")
public class GetRole {

    @RequestMapping(value = "/get_role/{emailB64}", method = RequestMethod.GET)
    public ResponseEntity<RoleEntity> get_role(@PathVariable("emailB64") String emailB64) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setErrorHandler(new ResponseErrorHandler() {
            @Override
            public boolean hasError(ClientHttpResponse clientHttpResponse) throws IOException {
                return false;
            }

            @Override
            public void handleError(ClientHttpResponse clientHttpResponse) throws IOException {
            }
        });

        ResponseEntity<UserEntity> userResponse = restTemplate.getForEntity(
                ServerProperties.modelUrl + "/users/get_user/{emailB64}",
                UserEntity.class, emailB64);
        if (userResponse.getStatusCode() == HttpStatus.OK) {
            return new ResponseEntity<>(new RoleEntity(userResponse.getBody().getRole()), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }
}
