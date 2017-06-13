package fii.admission.note;

import fii.admission.DTO.SuccessEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value = "/model")
@RestController
public class NoteController {
    @RequestMapping(value = "/note", method = RequestMethod.GET)
    public ResponseEntity<List<Note>> getAllNote() {
        List<Note> result = NoteService.getAllNote();

        if (result == null)
            return new ResponseEntity<List<Note>>(result, HttpStatus.NO_CONTENT);

        return new ResponseEntity<List<Note>>(result, HttpStatus.OK);
    }

    @RequestMapping(value = "/note/{candidatcnp}", method = RequestMethod.GET)
    public ResponseEntity<Note> getNote(@PathVariable String candidatcnp) {
        Note result = NoteService.getNote(candidatcnp, null);

        if (result == null)
            return new ResponseEntity<Note>(result, HttpStatus.NOT_FOUND);

        return new ResponseEntity<Note>(result, HttpStatus.OK);
    }

    @RequestMapping(value = "/note/{candidatcnp}/{criteria}", method = RequestMethod.GET)
    public ResponseEntity<Note> getNoteByCriteria(
            @PathVariable String candidatcnp,
            @PathVariable String criteria) {
        Note result = NoteService.getNote(candidatcnp, criteria);

        if (result == null)
            return new ResponseEntity<Note>(result, HttpStatus.NOT_FOUND);

        return new ResponseEntity<Note>(result, HttpStatus.OK);
    }

    @RequestMapping(value = "/note/{candidatcnp}", method = RequestMethod.POST)
    public ResponseEntity<SuccessEntity> updateNote(
            @PathVariable("candidatcnp") String candidatcnp,
            @RequestBody NoteDTO note) {
        System.out.println("[debug]/note/{cnp} ALL GOOD");
        Note entity = mapDtoToEntity(note, candidatcnp);
        int result = NoteService.insertNote(entity);
        if (result != 0)
            return new ResponseEntity<SuccessEntity>(new SuccessEntity(false), HttpStatus.NOT_MODIFIED);
        else
            return new ResponseEntity<SuccessEntity>(new SuccessEntity(true), HttpStatus.OK);
    }

    @RequestMapping(value = "/note/{candidatcnp}", method = RequestMethod.DELETE)
    public ResponseEntity<SuccessEntity> deleteNote(@PathVariable("candidatcnp") String candidatcnp) {
        int result = NoteService.deleteNote(candidatcnp);
        if (result == 0)
            return new ResponseEntity<SuccessEntity>(new SuccessEntity(false), HttpStatus.NOT_MODIFIED);
        else
            return new ResponseEntity<SuccessEntity>(new SuccessEntity(true), HttpStatus.OK);
    }

    @RequestMapping(value = "/note/{candidatcnp}", method = RequestMethod.PUT)
    public ResponseEntity<SuccessEntity> insertNote(
            @PathVariable("candidatcnp") String candidatcnp,
            @RequestBody NoteDTO note) {
        Note entity = mapDtoToEntity(note, candidatcnp);
        int result = NoteService.updateNote(entity);
        if (result == 0)
            return new ResponseEntity<SuccessEntity>(new SuccessEntity(false), HttpStatus.NOT_MODIFIED);
        else
            return new ResponseEntity<SuccessEntity>(new SuccessEntity(true), HttpStatus.OK);
    }

    private Note mapDtoToEntity(NoteDTO note, String candidatcnp){
        Note entity = new Note();
        entity.setCandidatCNP(candidatcnp);
        entity.setExamenid(note.getExamenid());
        entity.setValoare(note.getValoare());
        return entity;
    }
}
