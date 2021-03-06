package com.ip_b1.fii.admission.Controllers;




import com.ip_b1.fii.admission.DTO.*;
import com.ip_b1.fii.admission.ServerProperties;
import com.ip_b1.fii.admission.Utils.AuthUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/controller/submit_form")
public class SubmitForm {
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<SubmitFormOutEntity> run(@RequestBody FormEntity formEntity) {
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

        return new ResponseEntity<>(
                new SubmitFormOutEntity(true, null),
                HttpStatus.OK
        );

    }

    private static boolean addToDB(FormEntity formEntity) {

        FormOutEntity formOutEntity = new FormOutEntity(formEntity.getFields());
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<SuccessEntity> response = restTemplate.postForEntity(
                ServerProperties.modelUrl + "/{username}/submit_form",
                formOutEntity,
                SuccessEntity.class,
                formEntity.getAuth().getEmail()
        );
        return response.getStatusCode() == HttpStatus.CREATED && response.getBody().isSuccess();
    }
}

