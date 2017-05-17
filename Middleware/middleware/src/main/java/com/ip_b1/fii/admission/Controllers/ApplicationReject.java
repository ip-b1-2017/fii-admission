package com.ip_b1.fii.admission.Controllers;

import com.ip_b1.fii.admission.DTO.*;
import com.ip_b1.fii.admission.ServerProperties;
import com.ip_b1.fii.admission.Utils.AuthUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("controller/application_review_reject/")
public class ApplicationReject {

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<SuccessEntity> reject(@RequestBody ApplicationReview body) {

        if (!AuthUtils.checkAuthIsAdmin(body.getUser())) {
            return new ResponseEntity<>(new SuccessEntity(false), HttpStatus.UNAUTHORIZED);
        }

        if (!process(body.getCnp(), body.getMessage()))
            return new ResponseEntity<>(new SuccessEntity(false), HttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<>(new SuccessEntity(true), HttpStatus.OK);

    }

    private static boolean process(String cnp, String rejectionMessage) {
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<SuccessEntity> success = restTemplate.postForEntity(
                ServerProperties.modelUrl + "/formuri/set_status/" + cnp,
                rejectionMessage,
                SuccessEntity.class
        );
        return success.getBody().isSuccess();
    }
}
