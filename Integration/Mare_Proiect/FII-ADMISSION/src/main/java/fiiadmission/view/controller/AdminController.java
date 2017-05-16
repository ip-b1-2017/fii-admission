package fiiadmission.view.controller;

import com.sun.deploy.net.HttpResponse;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import validator.IValidator;
import validator.Validator;
import fiiadmission.view.Model.*;

import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Created by rusub on 5/14/2017.
 */
@Controller
public class AdminController {

    IValidator validator = new Validator();
    @RequestMapping(value = "/delete_teacher", method = RequestMethod.GET)
    public ModelAndView getTeachers(HttpServletRequest req, HttpServletResponse rep){
        return new ModelAndView("profesori");
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public void save(HttpServletRequest req){
        Map map = req.getParameterMap();
        if(validator.isValid(map)){
            //return 
        }
    }

    @RequestMapping(value = "/tabel_candidati", method = RequestMethod.GET)
    public ResponseEntity<List<CandidatForm>> loadTable() {
        RestTemplate template = new RestTemplate();

        ResponseEntity<List<CandidatForm>> candidatResponse;
        candidatResponse = template.exchange("http://localhost:9999/model/candidati_formuri", HttpMethod.GET,
                null, new ParameterizedTypeReference<List<CandidatForm>>() {
                });
        List<CandidatForm> candidates = candidatResponse.getBody();

        return new ResponseEntity<List<CandidatForm>>(
                candidates,
                HttpStatus.OK
        );
    }
}
