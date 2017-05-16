package fii.admission.examene;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ExamenController {
    @RequestMapping(value = "/examene", method = RequestMethod.GET)
    public ResponseEntity<List<Examen>> getAllExamen() {
        List<Examen> result = ExamenService.getAllExamen();

        if (result == null)
            return new ResponseEntity<List<Examen>>(result, HttpStatus.NO_CONTENT);

        return new ResponseEntity<List<Examen>>(result, HttpStatus.OK);
    }

    @RequestMapping(value = "/examene/{id}", method = RequestMethod.GET)
    public ResponseEntity<Examen> getExamen(@PathVariable String id) {
        Examen result = ExamenService.getExamen(id);

        if (result == null)
            return new ResponseEntity<Examen>(result, HttpStatus.NOT_FOUND);

        return new ResponseEntity<Examen>(result, HttpStatus.OK);
    }

    @RequestMapping(value = "/examene/{id}", method = RequestMethod.POST)
    public ResponseEntity<Integer> updateExamen(@PathVariable("id") String id, @RequestBody Examen examen) {
        int result = ExamenService.updateExamen(id, examen);
        if (result == 0)
            return new ResponseEntity<Integer>(result, HttpStatus.NOT_MODIFIED);
        else
            return new ResponseEntity<Integer>(result, HttpStatus.OK);
    }

    @RequestMapping(value = "/examene/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Integer> deleteExamen(@PathVariable("id") String id) {
        int result = ExamenService.deleteExamen(id);
        if (result == 0)
            return new ResponseEntity<Integer>(result, HttpStatus.NOT_MODIFIED);
        else
            return new ResponseEntity<Integer>(result, HttpStatus.OK);
    }

    @RequestMapping(value = "/examene", method = RequestMethod.PUT)
    public ResponseEntity<Integer> insertExamen(@RequestBody Examen examen) {
        int result = ExamenService.insertExamen(examen);
        if (result == 0)
            return new ResponseEntity<Integer>(result, HttpStatus.NOT_MODIFIED);
        else
            return new ResponseEntity<Integer>(result, HttpStatus.OK);
    }
}
