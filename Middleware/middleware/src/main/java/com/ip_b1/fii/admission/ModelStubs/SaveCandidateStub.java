package com.ip_b1.fii.admission.ModelStubs;

import com.ip_b1.fii.admission.DTO.Candidat;
import com.ip_b1.fii.admission.DTO.SuccessEntity;
import com.ip_b1.fii.admission.DTO.User;
import com.ip_b1.fii.admission.ServerProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Base64;

@RestController
@RequestMapping(value = "candidati")
public class SaveCandidateStub {
    @RequestMapping(value = "/email/{emailB64}", method = RequestMethod.GET)
    public ResponseEntity<User> verify(@PathVariable("emailB64") String emailB64) {
        String email = Base64.getDecoder().decode(emailB64.getBytes()).toString();
        RestTemplate template = new RestTemplate();
        ResponseEntity<User> u = template.getForEntity(
                ServerProperties.modelUrl + "users/get_user/{emailB64}",
                User.class,
                emailB64
        );
        if(email.equals("alexd@info.uaic.ro")) {
            return u;
        } else {
            return new ResponseEntity<>(
                    u.getBody(),
                    HttpStatus.NOT_FOUND
            );
        }
    }

    @RequestMapping(value = "{cnp}", method = RequestMethod.POST)
    ResponseEntity<SuccessEntity> update(@PathVariable("cnp") String cnp, @RequestBody Candidat candidat) {
        System.out.println(cnp);
        if(cnp.equals("1234567890123")) {
            return new ResponseEntity<>(
                    new SuccessEntity(false),
                    HttpStatus.NOT_FOUND
            );
        } else {
            return new ResponseEntity<>(
                    new SuccessEntity(true),
                    HttpStatus.OK
            );
        }
    }

    @RequestMapping(value = "", method = RequestMethod.PUT)
    ResponseEntity<SuccessEntity> insert(@RequestBody Candidat candidat) {
        if(candidat.getFirstname().equals("Alexx")) {
            return new ResponseEntity<>(
                    new SuccessEntity(false),
                    HttpStatus.BAD_REQUEST
            );
        } else {
            return new ResponseEntity<>(
                    new SuccessEntity(true),
                    HttpStatus.OK
            );
        }
    }
}
