package com.ip_b1.fii.admission.ModelStubs;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Claudia Lucasi on 5/21/2017.
 */
@RestController
@RequestMapping("get_result")
public class GetResultsStub {

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<String> getResults() {
        String results = new String();
        results="9.50";
        return new ResponseEntity<>(
                results,
                HttpStatus.OK
        );

    }

}
