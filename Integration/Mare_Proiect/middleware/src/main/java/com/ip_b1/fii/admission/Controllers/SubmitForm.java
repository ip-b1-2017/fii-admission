package com.ip_b1.fii.admission.Controllers;


import com.ip_b1.fii.admission.DTO.FormEntity;
import com.ip_b1.fii.admission.DTO.FormOutEntity;
import com.ip_b1.fii.admission.DTO.SubmitFormOutEntity;
import com.ip_b1.fii.admission.DTO.SuccessEntity;
import com.ip_b1.fii.admission.ServerProperties;
import com.ip_b1.fii.admission.Utils.AuthUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Iacob Cristian on 5/7/2017.
 */

@RestController
@RequestMapping("/controller/submit_form")
public class SubmitForm {
    private static boolean addToDB(FormEntity formEntity) {

        FormOutEntity formOutEntity = new FormOutEntity(formEntity.getFields());
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<SuccessEntity> response = restTemplate.postForEntity(
                ServerProperties.modelUrl + "/{username}/submit_form",
                formOutEntity,
                SuccessEntity.class,
                formEntity.getAuth().getUsername()
        );
        return response.getStatusCode() == HttpStatus.CREATED && response.getBody().isSuccess();
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<SubmitFormOutEntity> testLogin(@RequestBody FormEntity formEntity) {
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

