package com.ip_b1.fii.admission.Controllers;

import com.ip_b1.fii.admission.DTO.*;
import com.ip_b1.fii.admission.ServerProperties;
import com.ip_b1.fii.admission.Utils.AuthUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.management.BadAttributeValueExpException;
import java.util.Base64;

/**
 * Created by rusub on 6/12/2017.
 */
@RequestMapping(value = "/controller/note")
@RestController
public class GradeController {

    @RequestMapping(value = "/getFinal", method = RequestMethod.POST)
    public ResponseEntity<Grade> getFinalGrade(@RequestBody AuthEntity auth){
        boolean isAuth = AuthUtils.checkAuth(auth);
        Grade grade = new Grade();
        if(!isAuth)
            return new ResponseEntity<Grade>(HttpStatus.FORBIDDEN);

        RestTemplate restTemplate = new RestTemplate();

        try{

            System.out.println("[debug]@GradeController get OK status code");
            CandidateOutEntity candidateOutEntity =
                    this.getCandidate(restTemplate, auth.getUsername());
            grade.setFirstName(candidateOutEntity.getFirstname());
            grade.setLastName(candidateOutEntity.getLastname());

            ResponseEntity finalGradeResp =
                    restTemplate.getForEntity(
                            ServerProperties.modelUrl + "/note/{cnp}/{criteria}",
                            ResponseEntity.class,
                            candidateOutEntity.getCnp(),
                            ServerProperties.FINAL_GRADE
                    );

            if (!finalGradeResp.getStatusCode().equals(HttpStatus.OK)) {
                throw new BadAttributeValueExpException("HttpStatusCode is not OK");
            }

            GradeDTO finalGrade = (GradeDTO) finalGradeResp.getBody();
            grade.setGrade(finalGrade.getValoare());

        }catch(BadAttributeValueExpException ex){
            return new ResponseEntity<Grade>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<Grade>(grade, HttpStatus.OK);
    }

    @RequestMapping(value = "/addValue", method = RequestMethod.POST)
    public ResponseEntity addValue(
            @RequestBody GradePostStructure grade){
        boolean isAuth = AuthUtils.checkAuth(grade.getEntity());
        if(!isAuth)
            return new ResponseEntity(HttpStatus.FORBIDDEN);

        RestTemplate restTemplate = new RestTemplate();

        try{
            CandidateOutEntity candidateOutEntity =
                    this.getCandidate(restTemplate, grade.getEntity().getUsername());
            ResponseEntity response =
                    restTemplate.postForEntity(
                    ServerProperties.modelUrl + "/note/{cnp}",
                    grade.getGrade(),
                    ResponseEntity.class,
                    candidateOutEntity.getCnp()
            );
        } catch (BadAttributeValueExpException e) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(HttpStatus.CREATED);
    }

    private CandidateOutEntity getCandidate(RestTemplate template, String email)
            throws BadAttributeValueExpException {
        String emailB64 =
                new String(Base64.
                        getEncoder().
                        encode(email.getBytes()));

        ResponseEntity resp =
                template.getForEntity(
                        ServerProperties.modelUrl + "/candidati/email/" + emailB64,
                        ResponseEntity.class);

        if(!resp.getStatusCode().equals(HttpStatus.OK)) {
            throw new BadAttributeValueExpException("HttpStatusCode is not OK");
        }
        return (CandidateOutEntity)resp.getBody();
    }
}
