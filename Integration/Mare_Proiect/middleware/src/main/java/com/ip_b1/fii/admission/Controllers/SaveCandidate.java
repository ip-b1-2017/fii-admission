package com.ip_b1.fii.admission.Controllers;

import com.ip_b1.fii.admission.DTO.CandidateInEntity;
import com.ip_b1.fii.admission.DTO.CandidateOutEntity;
import com.ip_b1.fii.admission.DTO.SuccessEntity;
import com.ip_b1.fii.admission.DTO.UserEntity;
import com.ip_b1.fii.admission.ServerProperties;
import com.ip_b1.fii.admission.Utils.AuthUtils;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.Base64;

@RestController
@RequestMapping("controller/save_candidate")
public class SaveCandidate {
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<SuccessEntity> saveCandidate(CandidateInEntity candidate) {
        if (!AuthUtils.checkAuth(candidate.getAuth())) {
            return new ResponseEntity<>(new SuccessEntity(false), HttpStatus.UNAUTHORIZED);
        }
        if (addCandidate(candidate)){
            return new ResponseEntity<>(new SuccessEntity(true), HttpStatus.CREATED);
        }
        else{
            return new ResponseEntity<>(new SuccessEntity(false), HttpStatus.BAD_REQUEST);
        }
    }

    public static boolean addCandidate(CandidateInEntity candidate){
        CandidateOutEntity candidateOut = new CandidateOutEntity(candidate);
        RestTemplate template = new RestTemplate();

        ResponseEntity<UserEntity> existingUser;
        try{
            existingUser = template.getForEntity(
                    ServerProperties.modelUrl + "/candidati/email/{emailB64}",
                    UserEntity.class,
                    new String(Base64.getEncoder().encode(candidateOut.getEmail().getBytes()))
            );
            if (existingUser.getStatusCode() != HttpStatus.NOT_FOUND){
                //Update
                ResponseEntity<SuccessEntity> success = template.postForEntity(
                        ServerProperties.modelUrl + "/candidati/{cnp}",//TODO
                        candidateOut,
                        SuccessEntity.class,
                        candidate.getCnp()
                );
                return success.getStatusCode() == HttpStatus.OK && success.getBody().isSuccess();
            }
        }
        catch (RestClientException ignored) {
        }
        // Daca da NOT_FOUND (adica nu exista emailul deja), ajungem aici (intra in catch si dupa iese);
        // Daca da ca exista (OK), intra in if
        //Insert
        ResponseEntity<SuccessEntity> success = template.exchange(
                ServerProperties.modelUrl + "/candidati",
                HttpMethod.PUT,
                new HttpEntity<>(candidateOut),
                SuccessEntity.class
        );
        return success.getStatusCode() == HttpStatus.CREATED && success.getBody().isSuccess();
    }
}