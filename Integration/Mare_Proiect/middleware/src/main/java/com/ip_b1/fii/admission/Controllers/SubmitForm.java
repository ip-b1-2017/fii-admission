package com.ip_b1.fii.admission.Controllers;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ip_b1.fii.admission.DTO.FormInEntity;
import com.ip_b1.fii.admission.DTO.FormOutEntity;
import com.ip_b1.fii.admission.DTO.SubmitFormOutEntity;
import com.ip_b1.fii.admission.DTO.SuccessEntity;
import com.ip_b1.fii.admission.ServerProperties;
import com.ip_b1.fii.admission.Utils.AuthUtils;
import com.ip_b1.fii.admission.Utils.UserUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@RestController
@RequestMapping("/controller/submit_form")
public class SubmitForm {
    private static boolean addToDB(FormInEntity formEntity){
        FormOutEntity formOutEntity = null;
        try {
            formOutEntity = new FormOutEntity(
                    new ObjectMapper().writeValueAsString(formEntity.getFields()),
                    UserUtils.getCandidateCnp(formEntity.getAuth().getUsername()),
                    getStatus(formEntity.getFields()));
        } catch (JsonProcessingException e) {
            return false;
        }
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<SuccessEntity> response = restTemplate.postForEntity(
                ServerProperties.modelUrl + "/{username}/save_form",
                formOutEntity,
                SuccessEntity.class,
                formEntity.getAuth().getUsername()
        );
        return response.getStatusCode() == HttpStatus.CREATED && response.getBody().isSuccess();
    }

    private static String getStatus(Map<String, String> fields) {
        return null;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<SubmitFormOutEntity> testLogin(@RequestBody FormInEntity formEntity) {
        if (!AuthUtils.checkAuth(formEntity.getAuth())) {

            return new ResponseEntity<>(
                    new SubmitFormOutEntity(false, "Unauthorized"),
                    HttpStatus.UNAUTHORIZED
            );
        } else {


            if (!addToDB(formEntity)) {
                return new ResponseEntity<>(new SubmitFormOutEntity(false, "Internal Server Error"), HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<SubmitFormOutEntity>(
                new SubmitFormOutEntity(true, null),
                HttpStatus.OK
        );

    }
}

