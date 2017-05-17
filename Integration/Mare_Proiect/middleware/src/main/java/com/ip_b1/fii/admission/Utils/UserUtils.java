package com.ip_b1.fii.admission.Utils;

import com.ip_b1.fii.admission.DTO.CandidatEntity;
import com.ip_b1.fii.admission.ServerProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.Base64;

public class UserUtils {
    public static String getCandidateCnp(String username){
        try{
            RestTemplate template = new RestTemplate();
            ResponseEntity<CandidatEntity> response = template.getForEntity(
                    ServerProperties.modelUrl + "/candidati/email/{email}",
                    CandidatEntity.class,
                    new String(Base64.getEncoder().encode(username.getBytes()))
            );
            return response.getBody().getCNP();
        }
        catch(RestClientException ex){
            return null;
        }
    }
}
