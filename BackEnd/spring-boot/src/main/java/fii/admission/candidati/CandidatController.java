package fii.admission.candidati;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CandidatController {
	@RequestMapping(value = "/candidati", method = RequestMethod.GET)
	public ResponseEntity<List<Candidat>> getAllCandidat() {
		List<Candidat> result = CandidatService.getAllCandidat();
		
		if(result == null)
			return new ResponseEntity<List<Candidat>>(result, HttpStatus.NO_CONTENT);
		
		return new ResponseEntity<List<Candidat>>(result, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/candidati/{cnp}", method = RequestMethod.GET)
	public ResponseEntity<Candidat> getCandidat(@PathVariable String cnp) {
		Candidat result = CandidatService.getCandidat(cnp);
		
		if(result == null)
			return new ResponseEntity<Candidat>(result, HttpStatus.NOT_FOUND);

		return new ResponseEntity<Candidat>(result, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/candidati/{cnp}", method = RequestMethod.POST)
	public ResponseEntity<Integer> updateCandidat(@PathVariable("cnp") String cnp, @RequestBody Candidat candidat) {
		int result = CandidatService.updateCandidat(cnp, candidat);
		if(result == 0)
			return new ResponseEntity<Integer>(result, HttpStatus.NOT_MODIFIED);
		else 
			return new ResponseEntity<Integer>(result, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/candidati/{cnp}", method = RequestMethod.DELETE)
	public ResponseEntity<Integer> deleteCandidat(@PathVariable("cnp") String cnp) {
		int result = CandidatService.deleteCandidat(cnp);
		if(result == 0)
			return new ResponseEntity<Integer>(result, HttpStatus.NOT_MODIFIED);
		else 
			return new ResponseEntity<Integer>(result, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/candidati", method = RequestMethod.PUT)
	public ResponseEntity<Integer> insertCandidat(@RequestBody Candidat candidat) {
		int result = CandidatService.insertCandidat(candidat);
		if(result == 0)
			return new ResponseEntity<Integer>(result, HttpStatus.NOT_MODIFIED);
		else 
			return new ResponseEntity<Integer>(result, HttpStatus.OK);
	}
}

