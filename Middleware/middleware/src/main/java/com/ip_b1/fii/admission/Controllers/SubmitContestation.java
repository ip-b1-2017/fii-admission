package com.ip_b1.fii.admission.Controllers;

import com.ip_b1.fii.admission.DTO.*;
import com.ip_b1.fii.admission.ServerProperties;
import com.ip_b1.fii.admission.Utils.AuthUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/controller/{sessionId}/submit_contestation")

public class SubmitContestation {

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<SaveContestationOutEntity> testLogin(@PathVariable String sessionId, @RequestBody ContestationEntity contestationEntity) {
        if (!AuthUtils.checkAuth(contestationEntity.getAuth())) {

            return new ResponseEntity<>(
                    new SaveContestationOutEntity(false, "Unauthorized"),
                    HttpStatus.UNAUTHORIZED
            );
        } else {


            if (!addToDB(contestationEntity)) {
                return new ResponseEntity<>(new SaveContestationOutEntity(false, "Internal Server Error"), HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
        return new ResponseEntity<>(
                new SaveContestationOutEntity(true, null),
                HttpStatus.OK
        );

    }

    private static boolean addToDB(ContestationEntity contestationEntity) {

        contestationEntity = new ContestationEntity(contestationEntity.getContestation(), contestationEntity.getAuth());
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<SuccessEntity> response = restTemplate.postForEntity(
                ServerProperties.modelUrl + "/{username}/save_contestation",
                contestationEntity,
                SuccessEntity.class,
                contestationEntity.getAuth().getEmail()
        );
        return response.getStatusCode() == HttpStatus.CREATED && response.getBody().isSuccess();
    }
}
