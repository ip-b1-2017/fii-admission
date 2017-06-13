package fii.admission.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

/**
 * Created by andy on 07.06.2017.
 */
@RequestMapping(value = "/model")
@RestController
public class UtilsController {
    @RequestMapping(value = "/placement/students", method = RequestMethod.GET)
    public ResponseEntity<List<StudentsPlacement>> getStudentsPlacement() {

        List<StudentsPlacement> result = UtilsService.getStudentsPlacement();

        if (result == null)
            return new ResponseEntity<List<StudentsPlacement>>(result, HttpStatus.NO_CONTENT);

        return new ResponseEntity<List<StudentsPlacement>>(result, HttpStatus.OK);
    }

    @RequestMapping(value = "/placement/students/{filename}", method = RequestMethod.GET)
    public ResponseEntity<List<StudentsPlacement>> getStudentsPlacement(@PathVariable String fileName) {

        List<StudentsPlacement> result = UtilsService.getStudentsPlacement(fileName);

        if (result == null)
            return new ResponseEntity<List<StudentsPlacement>>(result, HttpStatus.NO_CONTENT);

        return new ResponseEntity<List<StudentsPlacement>>(result, HttpStatus.OK);
    }

    @RequestMapping(value = "/placement/profesori", method = RequestMethod.GET)
    public void getProfesoriPlacement() {
        UtilsService.getProfesoriPlacement();
    }

    @RequestMapping(value = "/export/{fileName}", method = RequestMethod.GET)
    public void exportStudents(@PathVariable String fileName) {
        UtilsService.exportStudents(fileName );
    }

}
