package com.ip_b1.fii.admission.ModelStubs;

import com.ip_b1.fii.admission.DTO.Note;
import com.ip_b1.fii.admission.DTO.SuccessEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddResultsStubs {

    private static int CNPcount = 0;

    @RequestMapping(value = "note", method = RequestMethod.PUT)
    public ResponseEntity<SuccessEntity> insertNote(@RequestBody Note note) {
        if(note.getCandidatCNP().equals("1234567")) {
            CNPcount++;
            if(CNPcount >= 2){
                return new ResponseEntity<>(new SuccessEntity(false), HttpStatus.NOT_MODIFIED);
            }
            return new ResponseEntity<>(new SuccessEntity(true), HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(new SuccessEntity(false), HttpStatus.NOT_MODIFIED);
    }

}
