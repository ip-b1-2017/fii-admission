package fii.admission.note;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NoteController {
	@RequestMapping(value = "/note", method = RequestMethod.GET)
	public ResponseEntity<List<Note>> getAllNote() {
		List<Note> result = NoteService.getAllNote();
		
		if(result == null)
			return new ResponseEntity<List<Note>>(result, HttpStatus.NO_CONTENT);
		
		return new ResponseEntity<List<Note>>(result, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/note/{candidatcnp}", method = RequestMethod.GET)
	public ResponseEntity<Note> getNote(@PathVariable String candidatcnp) {
		Note result = NoteService.getNote(candidatcnp);
		
		if(result == null)
			return new ResponseEntity<Note>(result, HttpStatus.NOT_FOUND);

		return new ResponseEntity<Note>(result, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/note/{candidatcnp}", method = RequestMethod.POST)
	public ResponseEntity<Integer> updateNote(@PathVariable("candidatcnp") String candidatcnp, @RequestBody Note note) {
		int result = NoteService.updateNote(candidatcnp, note);
		if(result == 0)
			return new ResponseEntity<Integer>(result, HttpStatus.NOT_MODIFIED);
		else 
			return new ResponseEntity<Integer>(result, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/note/{candidatcnp}", method = RequestMethod.DELETE)
	public ResponseEntity<Integer> deleteNote(@PathVariable("candidatcnp") String candidatcnp) {
		int result = NoteService.deleteNote(candidatcnp);
		if(result == 0)
			return new ResponseEntity<Integer>(result, HttpStatus.NOT_MODIFIED);
		else 
			return new ResponseEntity<Integer>(result, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/note", method = RequestMethod.PUT)
	public ResponseEntity<Integer> insertNote(@RequestBody Note note) {
		int result = NoteService.insertNote(note);
		if(result == 0)
			return new ResponseEntity<Integer>(result, HttpStatus.NOT_MODIFIED);
		else 
			return new ResponseEntity<Integer>(result, HttpStatus.OK);
	}
}
