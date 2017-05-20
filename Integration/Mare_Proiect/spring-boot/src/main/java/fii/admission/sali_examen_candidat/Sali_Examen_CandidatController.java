package fii.admission.sali_examen_candidat;

import fii.admission.DTO.SuccessEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value = "/model")
@RestController
public class Sali_Examen_CandidatController {
    @RequestMapping(value = "/sali_examen_candidat", method = RequestMethod.GET)
    public ResponseEntity<List<Sali_Examen_Candidat>> getAllSali_Examen_Candidat() {
        List<Sali_Examen_Candidat> result = Sali_Examen_CandidatService.getAllSali_Examen_Candidat();

        if (result == null)
            return new ResponseEntity<List<Sali_Examen_Candidat>>(result, HttpStatus.NO_CONTENT);

        return new ResponseEntity<List<Sali_Examen_Candidat>>(result, HttpStatus.OK);
    }

    @RequestMapping(value = "/sali_examen_candidat/{candidatcnp}", method = RequestMethod.GET)
    public ResponseEntity<Sali_Examen_Candidat> getSali_Examen_Candidat(@PathVariable String candidatcnp) {
        Sali_Examen_Candidat result = Sali_Examen_CandidatService.getSali_Examen_Candidat(candidatcnp);

        if (result == null)
            return new ResponseEntity<Sali_Examen_Candidat>(result, HttpStatus.NOT_FOUND);

        return new ResponseEntity<Sali_Examen_Candidat>(result, HttpStatus.OK);
    }

    @RequestMapping(value = "/sali_examen_candidat/{candidatcnp}", method = RequestMethod.POST)
    public ResponseEntity<SuccessEntity> updateSali_Examen_Candidat(@PathVariable("candidatcnp") String candidatcnp,
                                                                    @RequestBody Sali_Examen_Candidat sali) {
        int result = Sali_Examen_CandidatService.updateSali_Examen_Candidat(candidatcnp, sali);
        if (result == 0)
            return new ResponseEntity<SuccessEntity>(new SuccessEntity(false), HttpStatus.NOT_MODIFIED);
        else
            return new ResponseEntity<SuccessEntity>(new SuccessEntity(true), HttpStatus.OK);
    }

    @RequestMapping(value = "/sali_examen_candidat/{candidatcnp}", method = RequestMethod.DELETE)
    public ResponseEntity<SuccessEntity> deleteSali_Examen_Candidat(@PathVariable("candidatcnp") String candidatcnp) {
        int result = Sali_Examen_CandidatService.deleteSali_Examen_Candidat(candidatcnp);
        if (result == 0)
            return new ResponseEntity<SuccessEntity>(new SuccessEntity(false), HttpStatus.NOT_MODIFIED);
        else
            return new ResponseEntity<SuccessEntity>(new SuccessEntity(true), HttpStatus.OK);
    }

    @RequestMapping(value = "/sali_examen_candidat", method = RequestMethod.PUT)
    public ResponseEntity<SuccessEntity> insertSali_Examen_Candidat(@RequestBody Sali_Examen_Candidat sali) {
        int result = Sali_Examen_CandidatService.insertSali_Examen_Candidat(sali);
        if (result == 0)
            return new ResponseEntity<SuccessEntity>(new SuccessEntity(false), HttpStatus.NOT_MODIFIED);
        else
            return new ResponseEntity<SuccessEntity>(new SuccessEntity(true), HttpStatus.OK);
    }
}
