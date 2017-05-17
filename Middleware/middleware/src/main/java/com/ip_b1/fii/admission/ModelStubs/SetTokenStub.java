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
@RequestMapping("/users/set_token")
public class SetTokenStub {

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<SuccessEntity> testLogin(@RequestBody SetTokenEntity login) {
        SuccessEntity successEntity = new SuccessEntity();

            return new ResponseEntity<>(
                    new SuccessEntity(true),
                    HttpStatus.CREATED
            );

    }

}




