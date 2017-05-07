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
@RequestMapping("/controller/{sessionId}/get_applications")
public class GetApplications {

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<ApplicationsEntity> getApplications(@PathVariable String sessionId, @RequestBody AuthEntity auth) {
        if (!AuthUtils.checkAuth(auth)  || !AuthUtils.checkAuthIsAdmin(auth)) {

            return new ResponseEntity<ApplicationsEntity>(
                    new ApplicationsEntity(),
                    HttpStatus.UNAUTHORIZED
            );
        }
        else {


            RestTemplate template = new RestTemplate();

            ResponseEntity<ApplicationsEntity> entity = template.getForEntity(
                    ServerProperties.modelUrl + "}/get_applications",
                    ApplicationsEntity.class

            );

            return new ResponseEntity<ApplicationsEntity>(
                    entity.getBody(),
                    HttpStatus.OK
            );
        }
    }

}
