package fii.admission.candidati_forms;

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
public class CandidatFormController {
    @RequestMapping(value = "/candidati_formuri", method = RequestMethod.GET)
    public ResponseEntity<List<CandidatForm>> getAllUser() {
        List<CandidatForm> result = CandidatFormService.getAllCandidatForm();

        if (result == null)
            return new ResponseEntity<List<CandidatForm>>(result, HttpStatus.NO_CONTENT);

        return new ResponseEntity<List<CandidatForm>>(result, HttpStatus.OK);
    }
}
