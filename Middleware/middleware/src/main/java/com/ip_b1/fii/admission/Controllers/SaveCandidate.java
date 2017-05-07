package com.ip_b1.fii.admission.Controllers;

import com.ip_b1.fii.admission.DTO.CandidateInEntity;
import com.ip_b1.fii.admission.DTO.CandidateOutEntity;
import com.ip_b1.fii.admission.DTO.SuccessEntity;
import com.ip_b1.fii.admission.ServerProperties;
import com.ip_b1.fii.admission.Utils.AuthUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("controller/{sessionId}/save_candidate")
public class SaveCandidate {
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<SuccessEntity> saveCandidate(@PathVariable String sessionId, CandidateInEntity candidate) {
        if (!AuthUtils.checkAuth(candidate.getAuth())) {
            return new ResponseEntity<>(new SuccessEntity(false), HttpStatus.UNAUTHORIZED);
        }

        CandidateOutEntity result = new CandidateOutEntity(candidate);
        RestTemplate template = new RestTemplate();

        if (template.getForEntity(
                ServerProperties.modelUrl + "/{sessionId}/get_candidate?username={username}",
                SuccessEntity.class,
                sessionId,
                result.getEmail()
        ).getStatusCode() != HttpStatus.NOT_FOUND) {
            //Insert
            ResponseEntity<SuccessEntity> success = template.postForEntity(
                    ServerProperties.modelUrl + "/{sessionId}/insert_candidate",
                    result,
                    SuccessEntity.class,
                    sessionId
            );
            return new ResponseEntity<>(new SuccessEntity(
                    success.getStatusCode() == HttpStatus.CREATED && success.getBody().isSuccess()),
                    HttpStatus.OK);
        } else {
            //Update
            ResponseEntity<SuccessEntity> success = template.postForEntity(
                    ServerProperties.modelUrl + "/{sessionId}/update_candidate",
                    result,
                    SuccessEntity.class,
                    sessionId
            );
            return new ResponseEntity<>(new SuccessEntity(
                    success.getStatusCode() == HttpStatus.OK && success.getBody().isSuccess()),
                    HttpStatus.OK);
        }
    }
}