package fii.admission.forms;

import java.util.List;

import fii.admission.DTO.SuccessEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = "/model")
@RestController
public class FormController {
	@RequestMapping(value = "/formuri", method = RequestMethod.GET)
	public ResponseEntity<List<Form>> getAllForm() {
		List<Form> result = FormService.getAllForm();

		if (result == null)
			return new ResponseEntity<List<Form>>(result, HttpStatus.OK);

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
	public ResponseEntity<SuccessEntity> updateForm(@PathVariable("candidatcnp") String candidatcnp, @RequestBody Form form) {
		System.out.println(form.toString());
		int result = FormService.updateForm(candidatcnp, form);
		if (result == 0)
			return new ResponseEntity<>(new SuccessEntity(false), HttpStatus.NOT_FOUND);
		else
			return new ResponseEntity<>(new SuccessEntity(true), HttpStatus.OK);
	}

	@RequestMapping(value = "/formuri/set_status/{candidatcnp}", method = RequestMethod.POST)
	public ResponseEntity<SuccessEntity> updateFormStatus(@PathVariable("candidatcnp") String candidatcnp, @RequestBody String status) {
        System.out.println(candidatcnp + " " + status);
        Form form = FormService.getForm(candidatcnp);
        if (form == null){
        	return new ResponseEntity<>(new SuccessEntity(false), HttpStatus.NOT_FOUND);
		}

	    form.setStatus(status);
		int result = FormService.updateForm(candidatcnp, form);
		if (result == 0)
			return new ResponseEntity<>(new SuccessEntity(false), HttpStatus.NOT_FOUND);
		else
			return new ResponseEntity<> (new SuccessEntity(true), HttpStatus.OK);
	}

	@RequestMapping(value = "/formuri/{candidatcnp}", method = RequestMethod.DELETE)
	public ResponseEntity<SuccessEntity> deleteForm(@PathVariable("candidatcnp") String candidatcnp) {
		int result = FormService.deleteForm(candidatcnp);
		if (result == 0)
			return new ResponseEntity<>(new SuccessEntity(false), HttpStatus.NOT_FOUND);
		else
			return new ResponseEntity<>(new SuccessEntity(true), HttpStatus.OK);
	}

	@RequestMapping(value = "/formuri", method = RequestMethod.PUT)
	public ResponseEntity<SuccessEntity> insertForm(@RequestBody Form form) {
		int result = FormService.insertForm(form);
		if (result == 0)
			return new ResponseEntity<>(new SuccessEntity(false), HttpStatus.BAD_REQUEST);
		else
			return new ResponseEntity<>(new SuccessEntity(true), HttpStatus.CREATED);
	}
}

