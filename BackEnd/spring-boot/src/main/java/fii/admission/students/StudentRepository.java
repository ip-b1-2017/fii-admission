package fii.admission.students;

import java.util.List;

import org.springframework.data.repository.CrudRepository;


public interface StudentRepository extends CrudRepository<Student, String> {
	
}
