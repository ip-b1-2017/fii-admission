package com.ip_b1.fii.admission.ModelStubs;

import com.ip_b1.fii.admission.DTO.SuccessEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/formuri")
public class ApplicationReviewStub {

    @RequestMapping("/set_status/{cnp}")
    public ResponseEntity<SuccessEntity> setStatus(@PathVariable("cnp") String cnp){
        switch(cnp){
            case "123456":
                return new ResponseEntity<>(new SuccessEntity(true), HttpStatus.OK);
            default:
                return new ResponseEntity<>(new SuccessEntity(false), HttpStatus.NOT_FOUND);
        }
    }

}
