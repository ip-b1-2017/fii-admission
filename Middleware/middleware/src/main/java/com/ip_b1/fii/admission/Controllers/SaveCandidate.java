package com.ip_b1.fii.admission.Controllers;

import com.ip_b1.fii.admission.DTO.CandidateInEntity;
import com.ip_b1.fii.admission.DTO.Candidat;
import com.ip_b1.fii.admission.DTO.SuccessEntity;
import com.ip_b1.fii.admission.DTO.User;
import com.ip_b1.fii.admission.ServerProperties;
import com.ip_b1.fii.admission.Utils.AuthUtils;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.ResponseErrorHandler;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Base64;

@RestController
@RequestMapping("controller/save_candidate")
public class SaveCandidate {
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<SuccessEntity> saveCandidate(@RequestBody CandidateInEntity candidate) {
        if (!AuthUtils.checkAuth(candidate.getAuth())) {
            return new ResponseEntity<>(new SuccessEntity(false), HttpStatus.UNAUTHORIZED);
        }
        if (addCandidate(candidate)) {
            return new ResponseEntity<>(new SuccessEntity(true), HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(new SuccessEntity(false), HttpStatus.BAD_REQUEST);
        }
    }

    private static boolean addCandidate(CandidateInEntity candidate) {
        Candidat candidateOut = new Candidat(candidate);
        RestTemplate template = new RestTemplate();

        template.setErrorHandler(new ResponseErrorHandler() {
            @Override
            public boolean hasError(ClientHttpResponse clientHttpResponse) throws IOException {
                return false;
            }

            @Override
            public void handleError(ClientHttpResponse clientHttpResponse) throws IOException {
            }
        });

        ResponseEntity<User> existingUser;
        try {
            existingUser = template.getForEntity(
                    ServerProperties.modelUrl + "/candidati/email/{emailB64}",
                    User.class,
                    new String(Base64.getEncoder().encode(candidateOut.getEmail().getBytes()))
            );
            if (existingUser.getStatusCode() != HttpStatus.NOT_FOUND) {
                //Update
                ResponseEntity<SuccessEntity> success = template.postForEntity(
                        ServerProperties.modelUrl + "/candidati/{cnp}",
                        candidateOut,
                        SuccessEntity.class,
                        candidate.getCnp()
                );
                return success.getStatusCode() == HttpStatus.OK && success.getBody().isSuccess();
            }
        } catch (RestClientException ignored) {
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
        return success.getStatusCode() == HttpStatus.OK && success.getBody().isSuccess();
    }
}