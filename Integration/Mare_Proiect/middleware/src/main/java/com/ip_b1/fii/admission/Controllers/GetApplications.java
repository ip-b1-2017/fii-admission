package com.ip_b1.fii.admission.Controllers;

import com.ip_b1.fii.admission.DTO.ApplicationEntity;
import com.ip_b1.fii.admission.DTO.AuthEntity;
import com.ip_b1.fii.admission.ServerProperties;
import com.ip_b1.fii.admission.Utils.AuthUtils;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/controller/get_applications")
public class GetApplications {

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<List<ApplicationEntity>> run(@RequestBody AuthEntity auth) {
        if (!AuthUtils.checkAuth(auth)) {
            return new ResponseEntity<>(
                    HttpStatus.UNAUTHORIZED //Later checkAuthIsAdmin
            );
        } else {
            RestTemplate template = new RestTemplate();

            ResponseEntity<List<ApplicationEntity>> entity = template.exchange(
                    ServerProperties.modelUrl + "/candidati_formuri",
                    HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<List<ApplicationEntity>>(){}
            );

            return new ResponseEntity<>(
                    entity.getBody(),
                    HttpStatus.OK
            );
        }
    }

}
