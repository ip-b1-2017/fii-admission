package com.ip_b1.fii.admission.Controllers;

import com.ip_b1.fii.admission.DTO.AuthEntity;
import com.ip_b1.fii.admission.DTO.CandidateOutEntity;
import com.ip_b1.fii.admission.DTO.FormOutEntity;
import com.ip_b1.fii.admission.DTO.UserEntity;
import com.ip_b1.fii.admission.ServerProperties;
import com.ip_b1.fii.admission.Utils.AuthUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Base64;
import java.util.Map;


@RestController
public class GetForm {

    @RequestMapping(value = "/controller/get_form/{emailB64}", method = RequestMethod.GET)
    public ResponseEntity<Map<String, String>> getForm(@PathVariable("emailB64") String email){
        System.out.println("[debug][@GetForm] email: " + email);
        RestTemplate template = new RestTemplate();

        ResponseEntity<CandidateOutEntity> responseForCnp = template.getForEntity(
                ServerProperties.modelUrl + "/candidati/email/{emailB64}",
                CandidateOutEntity.class,
                email);

        if(responseForCnp.getStatusCode() == HttpStatus.OK){
            String cnp = responseForCnp.getBody().getCnp();
            ResponseEntity<Map>  responseForForm = template.getForEntity(
                    ServerProperties.modelUrl + "/formuri/{cnp}",
                    Map.class,
                    cnp);
            if(responseForForm.getStatusCode() == HttpStatus.OK){
                return new ResponseEntity<Map<String, String>>(
                        (Map<String, String>)responseForForm.getBody(),
                        HttpStatus.OK);
            }
        }
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @Deprecated
    @RequestMapping(value = "/controller/sessionId/get_form", method = RequestMethod.POST)
    public ResponseEntity<FormOutEntity> run(@PathVariable String sessionId, @RequestBody AuthEntity auth) {
        if (!AuthUtils.checkAuth(auth)) {
            return new ResponseEntity<>(
                    new FormOutEntity(null, null, null),
                    HttpStatus.UNAUTHORIZED
            );
        } else {


            RestTemplate template = new RestTemplate();

            ResponseEntity<FormOutEntity> entity = template.getForEntity(
                    ServerProperties.modelUrl + "/{sessionId}/get_form?username={username}",
                    FormOutEntity.class,
                    sessionId,
                    auth.getUsername()
            );

            return new ResponseEntity<>(
                    entity.getBody(),
                    HttpStatus.OK
            );
        }
    }

}
