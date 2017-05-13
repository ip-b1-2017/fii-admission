package fii.admission.medii;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MedieController {
	@RequestMapping(value = "/medii", method = RequestMethod.GET)
	public ResponseEntity<List<Medie>> getAllMedie() {
		List<Medie> result = MedieService.getAllMedie();
		
		if(result == null)
			return new ResponseEntity<List<Medie>>(result, HttpStatus.NO_CONTENT);
		
		return new ResponseEntity<List<Medie>>(result, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/medii/{candidatCNP}", method = RequestMethod.GET)
	public ResponseEntity<Medie> getMedie(@PathVariable String candidatCNP) {
		Medie result = MedieService.getMedie(candidatCNP);
		
		if(result == null)
			return new ResponseEntity<Medie>(result, HttpStatus.NOT_FOUND);

		return new ResponseEntity<Medie>(result, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/medii/{candidatCNP}", method = RequestMethod.POST)
	public ResponseEntity<Integer> updateMedie(@PathVariable("candidatCNP") String candidatCNP, @RequestBody Medie medie) {
		int result = MedieService.updateMedie(candidatCNP, medie);
		if(result == 0)
			return new ResponseEntity<Integer>(result, HttpStatus.NOT_MODIFIED);
		else 
			return new ResponseEntity<Integer>(result, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/medii/{candidatCNP}", method = RequestMethod.DELETE)
	public ResponseEntity<Integer> deleteMedie(@PathVariable("candidatCNP") String candidatCNP) {
		int result = MedieService.deleteMedie(candidatCNP);
		if(result == 0)
			return new ResponseEntity<Integer>(result, HttpStatus.NOT_MODIFIED);
		else 
			return new ResponseEntity<Integer>(result, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/medii", method = RequestMethod.PUT)
	public ResponseEntity<Integer> insertMedie(@RequestBody Medie medie) {
		int result = MedieService.insertMedie(medie);
		if(result == 0)
			return new ResponseEntity<Integer>(result, HttpStatus.NOT_MODIFIED);
		else 
			return new ResponseEntity<Integer>(result, HttpStatus.OK);
	}
}
