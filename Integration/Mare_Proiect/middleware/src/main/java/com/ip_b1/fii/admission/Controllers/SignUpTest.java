package com.ip_b1.fii.admission.Controllers;


import com.ip_b1.fii.admission.DTO.SignUpTestInEntity;
import com.ip_b1.fii.admission.DTO.SignUpTestOutEntity;
import com.ip_b1.fii.admission.DTO.SuccessEntity;
import com.ip_b1.fii.admission.DTO.UserEntity;
import com.ip_b1.fii.admission.ServerProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("controller/register")
public class SignUpTest {

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<SignUpTestOutEntity> testSignUp(@RequestBody SignUpTestInEntity signup) {

        System.out.println(signup.getEmail());

        if (check(signup)) {
            return new ResponseEntity<>(new SignUpTestOutEntity(false, "Email Used"), HttpStatus.BAD_REQUEST);
        }
        System.out.println("ce plm");
        if (!addToDB(signup)) {
            return new ResponseEntity<>(new SignUpTestOutEntity(false, "Internal Server Error"), HttpStatus
                    .INTERNAL_SERVER_ERROR);
        }
        System.out.println("ce plm");
        return new ResponseEntity<>(new SignUpTestOutEntity(true,  "salut"), HttpStatus.CREATED);
    }

    private static boolean check(SignUpTestInEntity signup) {
        Map<String,String> variable = new HashMap<>();
        variable.put("email",signup.getEmail());
        RestTemplate restTemplate = new RestTemplate();
        SuccessEntity entity = restTemplate.getForObject(
                ServerProperties.modelUrl + "/check_email/{email}",SuccessEntity.class,variable);
        return entity.isSuccess();
    }
    private static boolean addToDB(SignUpTestInEntity signup) {

        RestTemplate restTemplate = new RestTemplate();
        UserEntity user = new UserEntity();
        user.setEmail(signup.getEmail());
        user.setRole("user");
        user.setParola(signup.getPassword());
        user.setToken(".");
        ResponseEntity<SuccessEntity> response = restTemplate.postForEntity(
                ServerProperties.modelUrl + "/add_user",
                user,
                SuccessEntity.class);
        return response.getStatusCode() == HttpStatus.CREATED && response.getBody().isSuccess();
    }

}
