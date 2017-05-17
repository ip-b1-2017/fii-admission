package com.ip_b1.fii.admission.ModelStubs;

import com.ip_b1.fii.admission.DTO.LoginTestInEntity;
import com.ip_b1.fii.admission.DTO.LoginTestOutEntity;
import com.ip_b1.fii.admission.DTO.SetTokenEntity;
import com.ip_b1.fii.admission.DTO.SuccessEntity;
import com.ip_b1.fii.admission.ServerProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Random;

@RestController
@RequestMapping("/users/check_password")
public class CheckPasswordStub {

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<SuccessEntity> testLogin(@RequestBody LoginTestInEntity login) {
        System.out.println(login.getUsername() + " " + login.getPassword());
        if (login.getUsername().equals("user@info.uaic.com") && login.getPassword().equals("password")) {

            return new ResponseEntity<>(
                    new SuccessEntity(true),
                    HttpStatus.OK
            );
        }

            return new ResponseEntity<>(
                    new SuccessEntity(false),
                    HttpStatus.UNAUTHORIZED
            );

    }

}

