package com.ip_b1.fii.admission.Controllers;

import com.ip_b1.fii.admission.DTO.AuthEntity;
import com.ip_b1.fii.admission.DTO.FormOutEntity;
import com.ip_b1.fii.admission.ServerProperties;
import com.ip_b1.fii.admission.Utils.AuthUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;


@RestController
@RequestMapping("/controller/{sessionId}/get_form")
public  class GetForm {

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<FormOutEntity> run(@PathVariable String sessionId, @RequestBody AuthEntity auth) {
        if (!AuthUtils.checkAuth(auth)) {
            return new ResponseEntity<>(
                    new FormOutEntity(null),
                    HttpStatus.UNAUTHORIZED
            );
        } else {


            RestTemplate template = new RestTemplate();

            ResponseEntity<FormOutEntity> entity = template.getForEntity(
                    ServerProperties.modelUrl + "/{sessionId}/get_form?username={username}",
                    FormOutEntity.class,
                    sessionId,
                    auth.getEmail()
            );

            return new ResponseEntity<>(
                    entity.getBody(),
                    HttpStatus.OK
            );
        }
    }

}
