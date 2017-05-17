package fii.admission.candidati;

import fii.admission.DTO.SuccessEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Base64;
import java.util.List;

@RequestMapping(value = "/model")
@RestController
public class CandidatController {
    @RequestMapping(value = "/candidati", method = RequestMethod.GET)
    public ResponseEntity<List<Candidat>> getAllCandidat() {
        List<Candidat> result = CandidatService.getAllCandidat();

        if (result == null)
            return new ResponseEntity<List<Candidat>>(result, HttpStatus.NO_CONTENT);

        return new ResponseEntity<List<Candidat>>(result, HttpStatus.OK);
    }

    @RequestMapping(value = "/candidati/{cnp}", method = RequestMethod.GET)
    public ResponseEntity<Candidat> getCandidat(@PathVariable String cnp) {
        Candidat result = CandidatService.getCandidat(cnp);

        if (result == null)
            return new ResponseEntity<Candidat>(result, HttpStatus.NOT_FOUND);

        return new ResponseEntity<Candidat>(result, HttpStatus.OK);
    }

    @RequestMapping(value = "/candidati/email/{emailB64}", method = RequestMethod.GET)
    public ResponseEntity<Candidat> getCandidatByEmail(@PathVariable String emailB64){
        String email = new String(Base64.getDecoder().decode(emailB64));
        Candidat result = CandidatService.getCandidatByEmail(email);

        System.out.println("Request to " + email + " got " + result);

        if (result == null){
            return new ResponseEntity<Candidat>(result, HttpStatus.NOT_FOUND);
        }
        else {
            return new ResponseEntity<Candidat>(result, HttpStatus.OK);
        }
    }

    @RequestMapping(value = "/candidati/{cnp}", method = RequestMethod.POST)
    public ResponseEntity<SuccessEntity> updateCandidat(@PathVariable("cnp") String cnp, @RequestBody Candidat candidat) {
        int result = CandidatService.updateCandidat(cnp, candidat);
        if (result == 0)
            return new ResponseEntity<>(new SuccessEntity(false), HttpStatus.NOT_FOUND);
        else
            return new ResponseEntity<>(new SuccessEntity(true), HttpStatus.OK);
    }

    @RequestMapping(value = "/candidati/{cnp}", method = RequestMethod.DELETE)
    public ResponseEntity<SuccessEntity> deleteCandidat(@PathVariable("cnp") String cnp) {
        int result = CandidatService.deleteCandidat(cnp);
        if (result == 0)
            return new ResponseEntity<>(new SuccessEntity(false), HttpStatus.NOT_FOUND);
        else
            return new ResponseEntity<>(new SuccessEntity(true), HttpStatus.OK);
    }

    @RequestMapping(value = "/candidati", method = RequestMethod.PUT)
    public ResponseEntity<SuccessEntity> insertCandidat(@RequestBody Candidat candidat) {
        int result = CandidatService.insertCandidat(candidat);
        if (result == 0)
            return new ResponseEntity<>(new SuccessEntity(false), HttpStatus.BAD_REQUEST);
        else
            return new ResponseEntity<>(new SuccessEntity(true), HttpStatus.OK);
    }
}

