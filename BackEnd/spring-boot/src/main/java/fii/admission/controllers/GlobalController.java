package fii.admission.controllers;

import fii.admission.profesori.Profesor;
import fii.admission.profesori.ProfesoriService;
import fii.admission.students.Student;
import fii.admission.students.StudentsService;

import java.util.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class GlobalController {
	
	@RequestMapping(value = "/status", method = RequestMethod.GET)
	public String getVersion() {
		// TODO -> statistici despre db-uri
		return "I'm still alive...";
	}
	
}
