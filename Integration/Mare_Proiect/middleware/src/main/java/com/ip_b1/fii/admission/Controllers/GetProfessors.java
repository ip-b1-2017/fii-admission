package com.ip_b1.fii.admission.Controllers;

import com.ip_b1.fii.admission.DTO.CandidatEntity;
import com.ip_b1.fii.admission.DTO.ProfessorEntity;
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
@RequestMapping("/controller/get_professors")
public class GetProfessors {
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<List<ProfessorEntity>> run() {

        RestTemplate template = new RestTemplate();

        ResponseEntity<List<ProfessorEntity>> professorResponse =
                template.exchange(ServerProperties.modelUrl + "/profesori",
                        HttpMethod.GET, null, new ParameterizedTypeReference<List<ProfessorEntity>>() {
                        });
        List<ProfessorEntity> professors = professorResponse.getBody();

        return new ResponseEntity<List<ProfessorEntity>>(
                professors,
                HttpStatus.OK
        );
    }
}
