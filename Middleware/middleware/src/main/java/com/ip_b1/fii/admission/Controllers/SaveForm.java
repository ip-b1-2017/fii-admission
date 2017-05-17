package com.ip_b1.fii.admission.Controllers;

import com.ip_b1.fii.admission.DTO.*;
import com.ip_b1.fii.admission.Utils.AuthUtils;
import com.ip_b1.fii.admission.ServerProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/controller/get_form_fields")
public class SaveForm {

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<SaveFormOutEntity> testLogin(@RequestBody FormEntity formEntity) {
        if (!AuthUtils.checkAuth(formEntity.getAuth())) {

            return new ResponseEntity<>(
                    new SaveFormOutEntity(false, "Unauthorized"),
                    HttpStatus.UNAUTHORIZED
            );
        } else {


            if (!addToDB(formEntity)) {
                return new ResponseEntity<>(new SaveFormOutEntity(false, "Internal Server Error"), HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
        return new ResponseEntity<>(
                new SaveFormOutEntity(true, null),
                HttpStatus.OK
        );

    }

    private static boolean addToDB(FormEntity formEntity) {

        FormOutEntity formOutEntity = new FormOutEntity(formEntity.getFields());
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<SuccessEntity> response = restTemplate.postForEntity(
                ServerProperties.modelUrl + "/{username}/save_form",
                formOutEntity,
                SuccessEntity.class,
                formEntity.getAuth().getEmail()
        );
        return response.getStatusCode() == HttpStatus.CREATED && response.getBody().isSuccess();
    }

}