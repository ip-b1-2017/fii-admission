package com.ip_b1.fii.admission.Controllers;

import com.ip_b1.fii.admission.Controllers.DTO.AuthEntity;
import com.ip_b1.fii.admission.Controllers.DTO.FormOutEntity;
import com.ip_b1.fii.admission.Controllers.Utils.AuthUtils;
import com.ip_b1.fii.admission.ServerProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by fenea on 5/7/2017.
 */

@RestController
@RequestMapping("/controller/get_form_fields")
public class GetFormFields {

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<FormOutEntity> testLogin(@RequestBody AuthEntity auth) {
        if (!AuthUtils.checkAuth(auth)) {

            return new ResponseEntity<>(
                    new FormOutEntity( null),
                    HttpStatus.UNAUTHORIZED
            );
        }
        else {


            RestTemplate template = new RestTemplate();

            ResponseEntity<FormOutEntity> entity = template.getForEntity(
                    ServerProperties.modelUrl + "/get_form_fields?username={username}",
                    FormOutEntity.class,
                    auth.getUsername()
            );

            return new ResponseEntity<FormOutEntity>(
                    entity.getBody(),
                    HttpStatus.OK
            );
        }
    }

}