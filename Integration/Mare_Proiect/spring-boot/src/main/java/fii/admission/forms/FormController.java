package fii.admission.forms;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value = "/model")
@RestController
public class FormController {
    @RequestMapping(value = "/formuri", method = RequestMethod.GET)
    public ResponseEntity<List<Form>> getAllForm() {
        List<Form> result = FormService.getAllForm();

        if (result == null)
            return new ResponseEntity<List<Form>>(result, HttpStatus.NO_CONTENT);

        return new ResponseEntity<List<Form>>(result, HttpStatus.OK);
    }

    @RequestMapping(value = "/formuri/{candidatcnp}", method = RequestMethod.GET)
    public ResponseEntity<Form> getForm(@PathVariable String candidatcnp) {
        Form result = FormService.getForm(candidatcnp);

        if (result == null)
            return new ResponseEntity<Form>(result, HttpStatus.NOT_FOUND);

        return new ResponseEntity<Form>(result, HttpStatus.OK);
    }

    @RequestMapping(value = "/formuri/{candidatcnp}", method = RequestMethod.POST)
    public ResponseEntity<Integer> updateForm(@PathVariable("candidatcnp") String candidatcnp, @RequestBody Form form) {
        int result = FormService.updateForm(candidatcnp, form);
        if (result == 0)
            return new ResponseEntity<Integer>(result, HttpStatus.NOT_MODIFIED);
        else
            return new ResponseEntity<Integer>(result, HttpStatus.OK);
    }

    @RequestMapping(value = "/formuri/{candidatcnp}", method = RequestMethod.DELETE)
    public ResponseEntity<Integer> deleteForm(@PathVariable("candidatcnp") String candidatcnp) {
        int result = FormService.deleteForm(candidatcnp);
        if (result == 0)
            return new ResponseEntity<Integer>(result, HttpStatus.NOT_MODIFIED);
        else
            return new ResponseEntity<Integer>(result, HttpStatus.OK);
    }

    @RequestMapping(value = "/formuri", method = RequestMethod.PUT)
    public ResponseEntity<Integer> insertForm(@RequestBody Form form) {
        int result = FormService.insertForm(form);
        if (result == 0)
            return new ResponseEntity<Integer>(result, HttpStatus.NOT_MODIFIED);
        else
            return new ResponseEntity<Integer>(result, HttpStatus.OK);
    }
}

