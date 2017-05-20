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
@RequestMapping("/controller/remove_professor")
public class RemoveProfessor {

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<SuccessEntity> setResult(@RequestBody String cnpProfessor) {
        System.out.println("[Debug] Hello");
        String cnp = cnpProfessor;

        RestTemplate template = new RestTemplate();

        template.delete(
                ServerProperties.modelUrl + "/profesori/"+cnp);
/*
        ResponseEntity<String> response = template.exchange(ServerProperties.modelUrl + "/profesori",
                HttpMethod.PUT, ProfessorEntity, ProfessorEntity.class, professorToAdd);
*/
        SuccessEntity success = new SuccessEntity();
        success.setSuccess(true);
        success.setFailureReason("nice");
        return new ResponseEntity<SuccessEntity>(
                success,
                HttpStatus.OK
        );
    }
}