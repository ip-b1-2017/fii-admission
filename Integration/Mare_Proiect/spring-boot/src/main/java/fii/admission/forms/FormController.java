package fii.admission.forms;

import com.google.gson.Gson;
import fii.admission.DTO.SuccessEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

import static fii.admission.DebugHelper.printDebugMsg;

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
	public ResponseEntity<Map<String, String>> getForm(@PathVariable String candidatcnp) {
		Form result = FormService.getForm(candidatcnp);
		printDebugMsg("getForm - GET", "merge");
		if (result == null)
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		Map<String, String> form = (Map<String, String>)new Gson()
				.fromJson(result.getFields(), Map.class);
		form.put("status_code", result.getStatus());
		return new ResponseEntity<Map<String, String>>(form, HttpStatus.OK);
	}

	@RequestMapping(value = "/formuri/{candidatcnp}", method = RequestMethod.POST)
	public ResponseEntity<SuccessEntity> updateForm(@PathVariable("candidatcnp") String candidatcnp, @RequestBody Form form) {
		printDebugMsg("updateForm - POST", "merge " + candidatcnp);
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

