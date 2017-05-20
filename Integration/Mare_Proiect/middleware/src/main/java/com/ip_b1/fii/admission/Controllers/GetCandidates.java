package com.ip_b1.fii.admission.Controllers;

import com.ip_b1.fii.admission.DTO.CandidateOutEntity;
import com.ip_b1.fii.admission.ServerProperties;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/controller/get_candidates")
public class GetCandidates {

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<CandidateOutEntity>> run() {

        RestTemplate template = new RestTemplate();

        ResponseEntity<List<CandidateOutEntity>> candidatResponse =
                template.exchange(ServerProperties.modelUrl + "/candidati",
                        HttpMethod.GET, null, new ParameterizedTypeReference<List<CandidateOutEntity>>() {
                        });
        List<CandidateOutEntity> candidates = candidatResponse.getBody();

        return new ResponseEntity<>(
                candidates,
                HttpStatus.OK
        );
    }
}
