package com.ip_b1.fii.admission.Controllers;

import com.ip_b1.fii.admission.DTO.ApplicationsEntity;
import com.ip_b1.fii.admission.DTO.AuthEntity;
import com.ip_b1.fii.admission.DTO.FormOutEntity;
import com.ip_b1.fii.admission.ServerProperties;
import com.ip_b1.fii.admission.Utils.AuthUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * Created by fenea on 5/7/2017.
 */

@RestController
@RequestMapping("/controller/{sessionId}/get_application_by_Email/{email}")
public class GetApplicationByEmail {

        @RequestMapping(method = RequestMethod.POST)
        public ResponseEntity<FormOutEntity> getApplications(@PathVariable String sessionId, @PathVariable String email,@RequestBody AuthEntity auth) {
            if (!AuthUtils.checkAuth(auth)  || !AuthUtils.checkAuthIsAdmin(auth)) {

                return new ResponseEntity<FormOutEntity>(
                        new FormOutEntity(),
                        HttpStatus.UNAUTHORIZED
                );
            }
            else {


                RestTemplate template = new RestTemplate();

                ResponseEntity<FormOutEntity> entity = template.getForEntity(
                        ServerProperties.modelUrl + "}/get_application_by_email/{email}",
                        FormOutEntity.class

                );

                return new ResponseEntity<FormOutEntity>(
                        entity.getBody(),
                        HttpStatus.OK
                );
            }
        }
}
