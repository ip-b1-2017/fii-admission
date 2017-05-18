/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fii.admission.anunturi;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = "/model")
@RestController
public class AnunturiController {
	@RequestMapping(value = "/anunturi", method = RequestMethod.GET)
	public ResponseEntity<List<Anunturi>> getAllAnunturi() {
		List<Anunturi> result = AnunturiService.getAllAnunturi();
		
		if(result == null)
			return new ResponseEntity<List<Anunturi>>(result, HttpStatus.NO_CONTENT);

		return new ResponseEntity<List<Anunturi>>(result, HttpStatus.OK);
	}

	@RequestMapping(value = "/anunturi/{id}", method = RequestMethod.GET)
	public ResponseEntity<Anunturi> getAnunturi(@PathVariable int id) {
		Anunturi result = AnunturiService.getAnunturi(id);

		if(result == null)
			return new ResponseEntity<Anunturi>(result, HttpStatus.NOT_FOUND);

		return new ResponseEntity<Anunturi>(result, HttpStatus.OK);
	}

	@RequestMapping(value = "/anunturi/{id}", method = RequestMethod.POST)
	public ResponseEntity<Integer> updateAnunturi(@PathVariable("id") int id, @RequestBody Anunturi anunt) {
		int result = AnunturiService.updateAnunturi(id, anunt);
		if(result == 0)
			return new ResponseEntity<Integer>(result, HttpStatus.NOT_MODIFIED);
		else
			return new ResponseEntity<Integer>(result, HttpStatus.OK);
	}

	@RequestMapping(value = "/anunturi/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Integer> deleteAnunturi(@PathVariable("id") int id) {
		int result = AnunturiService.deleteAnunturi(id);
		if(result == 0)
			return new ResponseEntity<Integer>(result, HttpStatus.NOT_MODIFIED);
		else
			return new ResponseEntity<Integer>(result, HttpStatus.OK);
	}

	@RequestMapping(value = "/anunturi", method = RequestMethod.PUT)
	public ResponseEntity<Integer> insertAnunturi(@RequestBody Anunturi anunt) {
		int result = AnunturiService.insertAnunturi(anunt);
		if(result == 0)
			return new ResponseEntity<Integer>(result, HttpStatus.NOT_MODIFIED);
		else
			return new ResponseEntity<Integer>(result, HttpStatus.OK);
	}
}
