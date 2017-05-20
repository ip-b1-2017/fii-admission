package com.ip_b1.fii.admission.Controllers;

import com.ip_b1.fii.admission.DTO.ProfessorEntity;
import com.ip_b1.fii.admission.DTO.ResultInEntity;
import com.ip_b1.fii.admission.DTO.SuccessEntity;
import com.ip_b1.fii.admission.ServerProperties;
import com.ip_b1.fii.admission.Utils.AuthUtils;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/controller/add_professor")
public class InsertProfessor {

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<ProfessorEntity> setResult(@RequestBody ProfessorEntity professor) {
        ProfessorEntity professorToAdd = new ProfessorEntity();
        professorToAdd.setNume(professor.getNume());
        professorToAdd.setPrenume(professor.getPrenume());
        professorToAdd.setPCNP(professor.getPCNP());

        RestTemplate template = new RestTemplate();

        template.put(
                ServerProperties.modelUrl + "/profesori",
                professorToAdd);


        return new ResponseEntity<ProfessorEntity>(
                //response,
                HttpStatus.OK
        );
    }
}