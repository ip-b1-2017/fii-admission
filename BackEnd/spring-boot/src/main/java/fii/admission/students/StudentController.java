package fii.admission.students;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
	@RequestMapping(value = "/students", method = RequestMethod.GET)
	public List<Student> getAllStudents() {
		List<Student> result = StudentsService.getAllStudents();
		return result;
	}
	
	@RequestMapping(value = "/students/{cnp}", method = RequestMethod.GET)
	public Student getStudent(@PathVariable String cnp) {
		Student result = StudentsService.getStudent(cnp);
		return result;
	}

	@RequestMapping(value = "/students", method = RequestMethod.POST)
	public String addStudent(@RequestBody Student student) {
		if( StudentsService.addStudent(student) )
			return "";
		return "{\"status\": 409, \"message\": \"Conflict\"}";
	}
}
