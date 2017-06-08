package fii.admission.utils;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by andy on 07.06.2017.
 */
@RequestMapping(value = "/model")
@RestController
public class UtilsController {
    @RequestMapping(value = "/placement/students", method = RequestMethod.GET)
    public void getStudentsPlacement() {
        UtilsService.getStudentsPlacement();
    }

    @RequestMapping(value = "/placement/profesori", method = RequestMethod.GET)
    public void getProfesoriPlacement() {
        UtilsService.getProfesoriPlacement();
    }

    @RequestMapping(value = "/export/{fileName}/{format}", method = RequestMethod.GET)
    public void exportStudents(@PathVariable String fileName, @PathVariable String format) {
        UtilsService.exportStudents(fileName + "." + format);
    }

}
