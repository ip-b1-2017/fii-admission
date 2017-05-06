package fii.admission.controllers;

import fii.admission.students.Student;
import fii.admission.students.StudentsService;

import java.util.*;
import org.springframework.web.bind.annotation.*;

@RestController
public class StatsController {
	@RequestMapping(value = "/version", method = RequestMethod.GET)
	public String getVersion() {
		return "{\"version\": \"1.0\"}";
	}

	@RequestMapping(value = "/students", method = RequestMethod.GET)
	public List<Student> getAllStudents() {
		return StudentsService.getAllStudents();
	}
}
