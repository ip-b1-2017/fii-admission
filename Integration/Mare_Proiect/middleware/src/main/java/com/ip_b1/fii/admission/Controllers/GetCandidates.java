package com.ip_b1.fii.admission.Controllers;

import com.ip_b1.fii.admission.DTO.CandidatEntity;
import com.ip_b1.fii.admission.ServerProperties;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/controller/get_candidates")
public class GetCandidates {

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<CandidatEntity>> run() {

        RestTemplate template = new RestTemplate();

        ResponseEntity<List<CandidatEntity>> candidatResponse =
                template.exchange(ServerProperties.modelUrl + "/candidati" ,
                        HttpMethod.GET, null, new ParameterizedTypeReference<List<CandidatEntity>>() {
                        });
        List<CandidatEntity> candidates = candidatResponse.getBody();

        return new ResponseEntity<List<CandidatEntity>>(
                candidates,
                HttpStatus.OK
        );
    }
}
