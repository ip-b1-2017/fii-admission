package com.ip_b1.fii.admission.Controllers;

import com.ip_b1.fii.admission.DTO.AuthEntity;
import com.ip_b1.fii.admission.DTO.SuccessEntity;
import com.ip_b1.fii.admission.ServerProperties;
import com.ip_b1.fii.admission.Utils.AuthUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("controller/application_review_accept/cnp={CNP}")
public class ApplicationAccept {

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<SuccessEntity> accept(@PathVariable(name = "CNP") String CNP){

        //if(!AuthUtils.checkAuthIsAdmin(user)){
        //    return new ResponseEntity<>(new SuccessEntity(false), HttpStatus.UNAUTHORIZED);
        //}

        if(!process(CNP))
            return new ResponseEntity<>(new SuccessEntity(false), HttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<>(new SuccessEntity(true), HttpStatus.OK) ;

    }

    private static boolean process(String cnp) {

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<SuccessEntity> success = restTemplate.postForEntity(
                ServerProperties.modelUrl + "/formuri/set_status/" + cnp,
                "accepted",
                SuccessEntity.class
                );
        return success.getBody().isSuccess();
    }

}
