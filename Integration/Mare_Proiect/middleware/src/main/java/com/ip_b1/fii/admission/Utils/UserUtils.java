package com.ip_b1.fii.admission.Utils;

import com.ip_b1.fii.admission.DTO.CandidatEntity;
import com.ip_b1.fii.admission.ServerProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

public class UserUtils {
    public String getCandidateCnp(String username){
        try{
            RestTemplate template = new RestTemplate();
            try {
                ResponseEntity<CandidatEntity> response = template.getForEntity(
                        ServerProperties.modelUrl + "/candidat/email/{email}",
                        CandidatEntity.class,
                        username
                );
                return response.getBody().getCNP();
            }
            catch(RestClientException ex){
                return null;
            }
        }
    }
}
