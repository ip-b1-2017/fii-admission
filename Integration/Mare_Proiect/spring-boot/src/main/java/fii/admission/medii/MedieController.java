package fii.admission.medii;

import fii.admission.DTO.SuccessEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value = "/model")
@RestController
public class MedieController {
    @RequestMapping(value = "/medii", method = RequestMethod.GET)
    public ResponseEntity<List<Medie>> getAllMedie() {
        List<Medie> result = MedieService.getAllMedie();

        if (result == null)
            return new ResponseEntity<List<Medie>>(result, HttpStatus.NO_CONTENT);

        return new ResponseEntity<List<Medie>>(result, HttpStatus.OK);
    }

    @RequestMapping(value = "/medii/{candidatCNP}", method = RequestMethod.GET)
    public ResponseEntity<Medie> getMedie(@PathVariable String candidatCNP) {
        Medie result = MedieService.getMedie(candidatCNP);

        if (result == null)
            return new ResponseEntity<Medie>(result, HttpStatus.NOT_FOUND);

        return new ResponseEntity<Medie>(result, HttpStatus.OK);
    }

    @RequestMapping(value = "/medii/{candidatCNP}", method = RequestMethod.POST)
    public ResponseEntity<SuccessEntity> updateMedie(@PathVariable("candidatCNP") String candidatCNP, @RequestBody Medie medie) {
        int result = MedieService.updateMedie(candidatCNP, medie);
        if (result == 0)
            return new ResponseEntity<SuccessEntity>(new SuccessEntity(false), HttpStatus.NOT_MODIFIED);
        else
            return new ResponseEntity<SuccessEntity>(new SuccessEntity(true), HttpStatus.OK);
    }

    @RequestMapping(value = "/medii/{candidatCNP}", method = RequestMethod.DELETE)
    public ResponseEntity<SuccessEntity> deleteMedie(@PathVariable("candidatCNP") String candidatCNP) {
        int result = MedieService.deleteMedie(candidatCNP);
        if (result == 0)
            return new ResponseEntity<SuccessEntity>(new SuccessEntity(false), HttpStatus.NOT_MODIFIED);
        else
            return new ResponseEntity<SuccessEntity>(new SuccessEntity(true), HttpStatus.OK);
    }

    @RequestMapping(value = "/medii", method = RequestMethod.PUT)
    public ResponseEntity<SuccessEntity> insertMedie(@RequestBody Medie medie) {
        int result = MedieService.insertMedie(medie);
        if (result == 0)
            return new ResponseEntity<SuccessEntity>(new SuccessEntity(false), HttpStatus.NOT_MODIFIED);
        else
            return new ResponseEntity<SuccessEntity>(new SuccessEntity(true), HttpStatus.OK);
    }
}
