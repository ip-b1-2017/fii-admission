package com.ip_b1.fii.admission.Controllers;

import com.ip_b1.fii.admission.DTO.RoleEntity;
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
import java.util.HashMap;
import java.util.Map;

/**
 * Created by cosmin on 5/15/2017.
 */
@RestController
@RequestMapping("/controller")
public class GetRole {

    @RequestMapping(value = "/get_role/{token}", method = RequestMethod.GET)
    public ResponseEntity<RoleEntity> get_role(@PathVariable("token") String token) {

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

        Map<String, String> urlParams = new HashMap<String, String>();
        urlParams.put("token", token);
        ResponseEntity<RoleEntity> role = restTemplate.getForEntity(ServerProperties.modelUrl + "/users/get_role/{token}", RoleEntity.class, urlParams);
        if (role.getBody().getRole() != null) {
            return new ResponseEntity<RoleEntity>(role.getBody(), HttpStatus.OK);
        } else {
            return new ResponseEntity<RoleEntity>(role.getBody(), HttpStatus.NOT_FOUND);
        }

    }
}
