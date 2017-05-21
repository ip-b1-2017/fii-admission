package com.ip_b1.fii.admission.Controllers;

import com.ip_b1.fii.admission.DTO.SuccessEntity;
import com.ip_b1.fii.admission.ServerProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
@RequestMapping("/controller/remove_classroom")
public class RemoveClassroom {
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<SuccessEntity> setResult(@RequestBody String idClassroom) {
        String id = idClassroom;

        RestTemplate template = new RestTemplate();

        template.delete(
                ServerProperties.modelUrl + "/sali/"+id);

        SuccessEntity success = new SuccessEntity();
        success.setSuccess(true);
        return new ResponseEntity<SuccessEntity>(
                success,
                HttpStatus.OK
        );
    }
}
