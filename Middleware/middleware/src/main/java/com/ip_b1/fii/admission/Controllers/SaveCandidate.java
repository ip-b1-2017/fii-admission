package com.ip_b1.fii.admission.Controllers;

import com.ip_b1.fii.admission.DTO.CandidateInEntity;
import com.ip_b1.fii.admission.DTO.SuccessEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("controller/{sessionId}/save_candidate")
public class SaveCandidate {
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<SuccessEntity> saveCandidate(@PathVariable String sessionId, CandidateInEntity candidate){

    }
}
