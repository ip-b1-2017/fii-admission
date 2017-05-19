package com.ip_b1.fii.admission.Controllers;


import com.ip_b1.fii.admission.DTO.SignUpTestInEntity;
import com.ip_b1.fii.admission.DTO.SignUpTestOutEntity;
import com.ip_b1.fii.admission.DTO.SuccessEntity;
import com.ip_b1.fii.admission.DTO.UserEntity;
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
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("controller/register")
public class SignUpTest {

    private static boolean check(SignUpTestInEntity signup) {
        Map<String, String> variable = new HashMap<>();
        variable.put("email", signup.getEmail());
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
        System.out.println(ServerProperties.modelUrl + "/users/check_email");
        Map<String, String> map = new HashMap<>();
        map.put("email", signup.getEmail());
        ResponseEntity<SuccessEntity> entity = restTemplate.postForEntity(
                ServerProperties.modelUrl + "/users/check_email", map, SuccessEntity.class);
        System.out.println(entity.getBody().isSuccess());
        return entity.getBody().isSuccess();
    }

    private static boolean addToDB(SignUpTestInEntity signup) {

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
        UserEntity user = new UserEntity();
        user.setEmail(signup.getEmail());
        System.out.println(signup.getEmail());
        user.setRole("user");
        System.out.println(signup.getPswall());
        user.setParola(signup.getPswall());
        user.setToken(".");
        ResponseEntity<SuccessEntity> response = restTemplate.postForEntity(
                ServerProperties.modelUrl + "/users/add_user",
                user,
                SuccessEntity.class);
        return response.getStatusCode() == HttpStatus.CREATED && response.getBody().isSuccess();
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<SignUpTestOutEntity> testSignUp(@RequestBody SignUpTestInEntity signup) {


        System.out.println(signup.getEmail());
        if (!check(signup)) {
            return new ResponseEntity<>(new SignUpTestOutEntity(false, "Email Used"), HttpStatus.BAD_REQUEST);
        }
        System.out.println("ce plm");
        if (!addToDB(signup)) {
            return new ResponseEntity<>(new SignUpTestOutEntity(false, "Internal Server Error"), HttpStatus
                    .INTERNAL_SERVER_ERROR);
        }
        System.out.println("ce plm");
        return new ResponseEntity<>(new SignUpTestOutEntity(true, "salut"), HttpStatus.CREATED);
    }

}
