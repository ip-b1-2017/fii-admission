package com.ip_b1.fii.admission.Controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ip_b1.fii.admission.DTO.*;
import com.ip_b1.fii.admission.ServerProperties;
import com.ip_b1.fii.admission.Utils.AuthUtils;
import com.ip_b1.fii.admission.Utils.UserUtils;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@RestController
@RequestMapping("/controller/save_form")
public class SaveForm {

    private static boolean addToDB(FormInEntity formEntity) {
        String cnp = UserUtils.getCandidateCnp(formEntity.getAuth().getUsername());

        if (cnp == null){
            //De modificat odata ce se pune pre-formularul.
            CandidateInEntity candidate = getCandidate(formEntity);
            System.out.println(candidate);
            if (candidate != null && SaveCandidate.addCandidate(candidate)) {
                cnp = candidate.getCnp();
            }
            else {
                System.out.println("Candidate NULL or could not be added!");
                return false;
            }
        }

        FormOutEntity formOutEntity;

        try {
            formOutEntity = new FormOutEntity(
                    new ObjectMapper().writeValueAsString(formEntity.getFields()),
                    cnp,
                    getStatus(formEntity.getFields()));
        } catch (JsonProcessingException e) {
            System.out.println("Could not serialize JSON form.");
            return false;
        }
        RestTemplate restTemplate = new RestTemplate();

        try{
            ResponseEntity<SuccessEntity> response = restTemplate.postForEntity(
                    ServerProperties.modelUrl + "/formuri/{cnp}",
                    formOutEntity,
                    SuccessEntity.class,
                    cnp);
            if (response.getStatusCode() == HttpStatus.OK && response.getBody().isSuccess()) {
                return true;
            }
            else{
                System.out.println("Could not POST form (OK status code, but not success?)");
                return false;
            }
        }
        catch(RestClientException ex1){
            try{
                ResponseEntity<SuccessEntity> result = restTemplate.exchange(
                        ServerProperties.modelUrl + "/formuri/{cnp}",
                        HttpMethod.PUT,
                        new HttpEntity<>(formOutEntity),
                        SuccessEntity.class,
                        cnp);
                return result.getStatusCode() == HttpStatus.CREATED && result.getBody().isSuccess();
            }
            catch (RestClientException ex2){
                System.out.println("Form PUT returned Bad Request.");
                return false;
            }
        }
    }

    private static CandidateInEntity getCandidate(FormInEntity formEntity) {
        String cnp = formEntity.getFields().getOrDefault("initial-name", null); //?? aparent asa se cheama in frontend...
        String firstname = formEntity.getFields().getOrDefault("prenume-alfa", null);
        String lastname = formEntity.getFields().getOrDefault("actual-name-alfa", null);
        String phone = formEntity.getFields().getOrDefault("phone", null);

        if (cnp == null || firstname == null || lastname == null || phone == null){
            return null;
        }

        return new CandidateInEntity(formEntity.getAuth(), cnp, firstname, lastname, phone);
    }

    private static String getStatus(Map<String, String> fields) {
        for (Map.Entry<String, String> field : fields.entrySet()){
            if (field.getValue() == null){
                return "IN PROGRESS";
            }
        }
        //TODO: trebuie propagata niste informatie, care sunt campurile necesare si care nu...
        return "COMPLETE";
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<SaveFormOutEntity> saveFormPost(@RequestBody FormInEntity formEntity) {
        System.out.println("in saveFormPost");
        System.out.println(formEntity);
        if (!AuthUtils.checkAuth(formEntity.getAuth())) {
            return new ResponseEntity<>(
                    new SaveFormOutEntity(false, "Unauthorized"),
                    HttpStatus.UNAUTHORIZED
            );
        }
        else if (!addToDB(formEntity)) {
            System.out.println("Internal server error: addToDb returned false");
            return new ResponseEntity<>(
                    new SaveFormOutEntity(false, "Internal Server Error"),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(
                new SaveFormOutEntity(true, null),
                HttpStatus.OK
        );

    }

}