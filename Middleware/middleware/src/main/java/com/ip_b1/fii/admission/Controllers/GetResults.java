package com.ip_b1.fii.admission.Controllers;

import com.ip_b1.fii.admission.DTO.AuthEntity;
import com.ip_b1.fii.admission.ServerProperties;
import com.ip_b1.fii.admission.Utils.AuthUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

public class GetResults {

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<String> getResults(@RequestBody AuthEntity auth) {
        if (!AuthUtils.checkAuth(auth)) {
            return new ResponseEntity<>(
                    "Unauthorized",
                    HttpStatus.UNAUTHORIZED
            );
        } else {
            RestTemplate template = new RestTemplate();

            ResponseEntity<String> entity = template.getForEntity(
                    ServerProperties.modelUrl + "get_result",
                    String.class
            );
            if (entity.getBody() == null)
                return new ResponseEntity<>(
                        entity.getBody(),
                        HttpStatus.NOT_FOUND

                );

            return new ResponseEntity<>(
                    entity.getBody(),
                    HttpStatus.OK

            );
        }
    }
}
