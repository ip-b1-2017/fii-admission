package fii.admission.candidati_forms;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping(value = "/model")
@RestController
public class CandidatFormController {
    @RequestMapping(value = "/candidati_formuri", method = RequestMethod.GET)
    public ResponseEntity<List<CandidatForm>> getAllCandidatiAndForms() {
        System.out.print("[debug][getAllCandidatiAndForms] ");
        List<CandidatForm> result = CandidatFormService.getAllCandidatForm();
        System.out.println(result.size() + " results");

        if (result == null)
            return new ResponseEntity<List<CandidatForm>>(result, HttpStatus.NO_CONTENT);

        return new ResponseEntity<List<CandidatForm>>(result, HttpStatus.OK);
    }
}
