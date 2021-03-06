package fii.admission.sali_examen;

import fii.admission.DTO.SuccessEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value = "/model")
@RestController
public class SaliExamenController {
    @RequestMapping(value = "/saliexamen", method = RequestMethod.GET)
    public ResponseEntity<List<SaliExamen>> getAllSaliExamen() {
        List<SaliExamen> result = SaliExamenService.getAllSaliExamen();

        if (result == null)
            return new ResponseEntity<List<SaliExamen>>(result, HttpStatus.NO_CONTENT);

        return new ResponseEntity<List<SaliExamen>>(result, HttpStatus.OK);
    }

    @RequestMapping(value = "/saliexamen/{saliid}", method = RequestMethod.GET)
    public ResponseEntity<SaliExamen> getSaliExamen(@PathVariable String saliid) {
        SaliExamen result = SaliExamenService.getSaliExamen(saliid);

        if (result == null)
            return new ResponseEntity<SaliExamen>(result, HttpStatus.NOT_FOUND);

        return new ResponseEntity<SaliExamen>(result, HttpStatus.OK);
    }

    @RequestMapping(value = "/saliexamen/{saliid}", method = RequestMethod.POST)
    public ResponseEntity<SuccessEntity> updateSaliExamen(@PathVariable("saliid") String saliid,
                                                          @RequestBody SaliExamen saliExamen) {
        int result = SaliExamenService.updateSaliExamen(saliid, saliExamen);
        if (result == 0)
            return new ResponseEntity<SuccessEntity>(new SuccessEntity(false), HttpStatus.NOT_MODIFIED);
        else
            return new ResponseEntity<SuccessEntity>(new SuccessEntity(true), HttpStatus.OK);
    }

    @RequestMapping(value = "/saliexamen/{saliid}", method = RequestMethod.DELETE)
    public ResponseEntity<SuccessEntity> deleteSaliExamen(@PathVariable("saliid") String saliid) {
        int result = SaliExamenService.deleteSaliExamen(saliid);
        if (result == 0)
            return new ResponseEntity<SuccessEntity>(new SuccessEntity(false), HttpStatus.NOT_MODIFIED);
        else
            return new ResponseEntity<SuccessEntity>(new SuccessEntity(true), HttpStatus.OK);
    }

    @RequestMapping(value = "/saliexamen", method = RequestMethod.PUT)
    public ResponseEntity<SuccessEntity> insertSaliExamen(@RequestBody SaliExamen saliExamen) {
        int result = SaliExamenService.insertSaliExamen(saliExamen);
        if (result == 0)
            return new ResponseEntity<SuccessEntity>(new SuccessEntity(false), HttpStatus.NOT_MODIFIED);
        else
            return new ResponseEntity<SuccessEntity>(new SuccessEntity(true), HttpStatus.OK);
    }
}
