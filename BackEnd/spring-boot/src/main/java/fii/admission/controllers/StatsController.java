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
		List<Student> result = StudentsService.getAllStudents();
		//if (result.size() == 0)
		//	return "{\"status\": 404, \"message\": \"Not Found\"}";
		return result;
	}
	
	@RequestMapping(value = "/students/{cnp}", method = RequestMethod.GET)
	public Student getStudent(@PathVariable String cnp) {
		Student result = StudentsService.getStudent(cnp);
		return result;
		//if (result == null)
		//	return "{\"status\": 404, \"message\": \"Not Found\"}";
	}

	@RequestMapping(value = "/students", method = RequestMethod.POST)
	public String addStudent(@RequestBody Student student) {
		if( StudentsService.addStudent(student) )
			return "";
		return "{\"status\": 409, \"message\": \"Conflict\"}";
	}
}
