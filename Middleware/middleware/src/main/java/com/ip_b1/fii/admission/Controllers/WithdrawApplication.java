package com.ip_b1.fii.admission.Controllers;

import com.ip_b1.fii.admission.DTO.AuthEntity;
import com.ip_b1.fii.admission.DTO.FormStatusEntity;
import com.ip_b1.fii.admission.DTO.SuccessEntity;
import com.ip_b1.fii.admission.ServerProperties;
import com.ip_b1.fii.admission.Utils.AuthUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/controller/{sessionId}/withdraw_application")
public class WithdrawApplication {

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<SuccessEntity> withdrawApplication(@PathVariable String sessionId, AuthEntity auth, String CNP) {
        if (!AuthUtils.checkAuth(auth) || !AuthUtils.checkAuthIsAdmin(auth)) {
            return new ResponseEntity<>(
                    new SuccessEntity(false),
                    HttpStatus.UNAUTHORIZED
            );
        }

        if(!process(sessionId, CNP))
        {
            return new ResponseEntity<>(new SuccessEntity(false), HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(new SuccessEntity(true), HttpStatus.OK);
    }


    private static boolean process(String sessionId, String cnp)
    {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<SuccessEntity> success = restTemplate.postForEntity(
                ServerProperties.modelUrl + "/model/(sessionId)/withdraw_application",
                new FormStatusEntity(cnp, "withdrawn"),
                SuccessEntity.class,
                sessionId);
        return success.getBody().isSuccess();
    }
}
