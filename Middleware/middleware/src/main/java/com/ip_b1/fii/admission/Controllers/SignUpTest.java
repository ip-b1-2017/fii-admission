package com.ip_b1.fii.admission.Controllers;


import com.ip_b1.fii.admission.DTO.SignUpTestInEntity;
import com.ip_b1.fii.admission.DTO.SignUpTestOutEntity;
import com.ip_b1.fii.admission.DTO.SuccessEntity;
import com.ip_b1.fii.admission.ServerProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("controller/signup_test")
public class SignUpTest {

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<SignUpTestOutEntity> testSignUp(@RequestBody SignUpTestInEntity signup) {

        if (!check(signup)) {
            return new ResponseEntity<>(new SignUpTestOutEntity(false, "Email Used"), HttpStatus.BAD_REQUEST);
        }
        if (!addToDB(signup)) {
            return new ResponseEntity<>(new SignUpTestOutEntity(false, "Internal Server Error"), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(new SignUpTestOutEntity(true, null), HttpStatus.CREATED);
    }

    private static boolean check(SignUpTestInEntity signup) {

        RestTemplate restTemplate = new RestTemplate();
        SuccessEntity entity = restTemplate.postForObject(
                ServerProperties.modelUrl + "/model/check_email",
                signup,
                SuccessEntity.class);
        return entity.isSuccess();

    }

    private static boolean addToDB(SignUpTestInEntity signup) {

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<SuccessEntity> response = restTemplate.postForEntity(
                ServerProperties.modelUrl + "/model/add",
                signup,
                SuccessEntity.class);
        return response.getStatusCode() == HttpStatus.CREATED && response.getBody().isSuccess();
    }

}
