package fii.admission.profesori;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value = "/model")
@RestController
public class ProfesorController {
    @RequestMapping(value = "/profesori", method = RequestMethod.GET)
    public ResponseEntity<List<Profesor>> getAllProfesori() {
        List<Profesor> result = ProfesoriService.getAllProfesori();

        if (result == null)
            return new ResponseEntity<List<Profesor>>(result, HttpStatus.NO_CONTENT);

        return new ResponseEntity<List<Profesor>>(result, HttpStatus.OK);
    }

    @RequestMapping(value = "/profesori/{cnp}", method = RequestMethod.GET)
    public ResponseEntity<Profesor> getProfesor(@PathVariable String cnp) {
        Profesor result = ProfesoriService.getProfesor(cnp);

        if (result == null)
            return new ResponseEntity<Profesor>(result, HttpStatus.NOT_FOUND);

        return new ResponseEntity<Profesor>(result, HttpStatus.OK);
    }

    @RequestMapping(value = "/profesori/{cnp}", method = RequestMethod.POST)
    public ResponseEntity<Integer> updateProfesor(@PathVariable("cnp") String cnp, @RequestBody Profesor prof) {
        int result = ProfesoriService.updateProfesor(cnp, prof);
        if (result == 0)
            return new ResponseEntity<Integer>(result, HttpStatus.NOT_MODIFIED);
        else
            return new ResponseEntity<Integer>(result, HttpStatus.OK);
    }

    @RequestMapping(value = "/profesori/{cnp}", method = RequestMethod.DELETE)
    public ResponseEntity<Integer> deleteProfesor(@PathVariable("cnp") String cnp) {
        int result = ProfesoriService.deleteProfesor(cnp);
        if (result == 0)
            return new ResponseEntity<Integer>(result, HttpStatus.NOT_MODIFIED);
        else
            return new ResponseEntity<Integer>(result, HttpStatus.OK);
    }

    @RequestMapping(value = "/profesori", method = RequestMethod.PUT)
    public ResponseEntity<Integer> insertProfesor(@RequestBody Profesor prof) {
        int result = ProfesoriService.insertProfesor(prof);
        if (result == 0)
            return new ResponseEntity<Integer>(result, HttpStatus.NOT_MODIFIED);
        else
            return new ResponseEntity<Integer>(result, HttpStatus.OK);
    }
}
