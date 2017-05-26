package com.ip_b1.fii.admission.Controllers;

import com.ip_b1.fii.admission.DTO.*;
import com.ip_b1.fii.admission.ServerProperties;
import com.ip_b1.fii.admission.Utils.AuthUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("controller/application_review_reject/cnp={CNP}")
public class ApplicationReject {

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<SuccessEntity> reject(@PathVariable(name = "CNP") String CNP) {
        if (process(CNP))
            return new ResponseEntity<>(new SuccessEntity(true), HttpStatus.OK);
        return new ResponseEntity<>(new SuccessEntity(false), HttpStatus.INTERNAL_SERVER_ERROR);

    }

    private static boolean process(String cnp) {

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<SuccessEntity> success = restTemplate.postForEntity(
                ServerProperties.modelUrl + "/formuri/set_status/" + cnp,
                "rejected",
                SuccessEntity.class
        );
        return success.getBody().isSuccess();
    }
}
