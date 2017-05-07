package com.ip_b1.fii.admission.Controllers;

import com.ip_b1.fii.admission.DTO.AuthEntity;
import com.ip_b1.fii.admission.DTO.NotificationsOutEntity;
import com.ip_b1.fii.admission.DTO.ResultInEntity;
import com.ip_b1.fii.admission.ServerProperties;
import com.ip_b1.fii.admission.Utils.AuthUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/controller/set_result")
public class AddResults {

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<String> setResult(@RequestBody ResultInEntity result) {
        if (!AuthUtils.checkAuth(result.getAuth()) || !AuthUtils.checkAuthIsAdmin(result.getAuth())) {
            return new ResponseEntity<>(
                    new String("UNAUTHORIZED"),
                    HttpStatus.UNAUTHORIZED
            );
        } else {
            RestTemplate template = new RestTemplate();

            ResponseEntity<String> entity = template.getForEntity(
                    ServerProperties.modelUrl + "/set_result",
                    String.class
            );

            return new ResponseEntity<>(
                    entity.getBody(),
                    HttpStatus.OK
            );
        }
    }

}
