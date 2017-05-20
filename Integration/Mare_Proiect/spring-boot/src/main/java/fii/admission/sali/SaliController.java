package fii.admission.sali;

import fii.admission.DTO.SuccessEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value = "/model")
@RestController
public class SaliController {
    @RequestMapping(value = "/sali", method = RequestMethod.GET)
    public ResponseEntity<List<Sali>> getAllSali() {
        List<Sali> result = SaliService.getAllSali();

        if (result == null)
            return new ResponseEntity<List<Sali>>(result, HttpStatus.NO_CONTENT);

        return new ResponseEntity<List<Sali>>(result, HttpStatus.OK);
    }

    @RequestMapping(value = "/sali/{id}", method = RequestMethod.GET)
    public ResponseEntity<Sali> getSali(@PathVariable String id) {
        Sali result = SaliService.getSali(id);

        if (result == null)
            return new ResponseEntity<Sali>(result, HttpStatus.NOT_FOUND);

        return new ResponseEntity<Sali>(result, HttpStatus.OK);
    }

    @RequestMapping(value = "/sali/{id}", method = RequestMethod.POST)
    public ResponseEntity<SuccessEntity> updateSali(@PathVariable("id") String id, @RequestBody Sali sali) {
        int result = SaliService.updateSali(id, sali);
        if (result == 0)
            return new ResponseEntity<SuccessEntity>(new SuccessEntity(false), HttpStatus.NOT_MODIFIED);
        else
            return new ResponseEntity<SuccessEntity>(new SuccessEntity(true), HttpStatus.OK);
    }

    @RequestMapping(value = "/sali/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<SuccessEntity> deleteSali(@PathVariable("id") String id) {
        int result = SaliService.deleteSali(id);
        if (result == 0)
            return new ResponseEntity<SuccessEntity>(new SuccessEntity(false), HttpStatus.NOT_MODIFIED);
        else
            return new ResponseEntity<SuccessEntity>(new SuccessEntity(true), HttpStatus.OK);
    }

    @RequestMapping(value = "/sali", method = RequestMethod.PUT)
    public ResponseEntity<SuccessEntity> insertSali(@RequestBody Sali sali) {
        int result = SaliService.insertSali(sali);
        if (result == 0)
            return new ResponseEntity<SuccessEntity>(new SuccessEntity(false), HttpStatus.NOT_MODIFIED);
        else
            return new ResponseEntity<SuccessEntity>(new SuccessEntity(true), HttpStatus.OK);
    }
}
