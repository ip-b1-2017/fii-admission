package fiiadmission.view.controller;

import fiiadmission.ServerProperties;
import fiiadmission.TolerantRestTemplate;
import fiiadmission.dto.AuthEntity;
import fiiadmission.dto.CandidateOutEntity;
import fiiadmission.dto.FormOutEntity;
import fiiadmission.dto.SuccessReasonEntity;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.apache.xerces.impl.dv.util.Base64;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import validator.Mapper;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

@Controller
public class FormController {

    @RequestMapping(value = "/form", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView getForm(HttpServletRequest req){
        AuthEntity auth = AuthEntity.fromCookies(req.getCookies());
        if(auth == null){
            return new ModelAndView("/login");
        }
        else{
            RestTemplate template = new TolerantRestTemplate();
            String emailB64 = new String(Base64.encode(auth.getUsername().getBytes()));
            System.out.println("[debug][@FormController] emailB64: " + emailB64);

            ResponseEntity<Map> response = template.getForEntity(
                    ServerProperties.middleUrl + "/get_form/{emailB64}",
                    Map.class,
                    emailB64);
            Map<String, String> form;
            if(response.getStatusCode() == HttpStatus.NO_CONTENT){
                //TODO do something
            }
            else {
                 form = (Map<String, String>) response.getBody();
                for (Map.Entry<String, String> entry : form.entrySet()) {
                    System.out.println(entry.getKey() + " " + entry.getValue());
                }
            }
            return new ModelAndView("/form");
        }
    }

    @RequestMapping(value = "/preform", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView getPreform(HttpServletRequest req){
        AuthEntity auth = AuthEntity.fromCookies(req.getCookies());
        if(auth == null){
            System.out.println("PRINTLN@CLASS[FormController]: getPreform/if (auth is null)");

            return new ModelAndView("/login");
        }
        else{
            System.out.println("PRINTLN@CLASS[FormController]: getPreform/else (auth not null)");

            RestTemplate template = new TolerantRestTemplate();

            ResponseEntity<SuccessReasonEntity> result = template.postForEntity(
                    ServerProperties.middleUrl + "/check_if_candidate",
                    auth, SuccessReasonEntity.class);
            if(result.getStatusCode() == HttpStatus.NOT_FOUND){
                return new ModelAndView("/preform");
            }
            return new ModelAndView("/form");
        }
    }

    @RequestMapping(value = "/preform_post", method = RequestMethod.POST)
    public ResponseEntity<SuccessReasonEntity> postPreform(HttpServletRequest req, HttpServletResponse res) throws IOException {
        AuthEntity auth = AuthEntity.fromCookies(req.getCookies());
        if(auth == null){
            return new ResponseEntity<>(
                    new SuccessReasonEntity(false, "redirect:/login"),
                    HttpStatus.UNAUTHORIZED);
        }
        else{
            Map<String, String[]> map = req.getParameterMap();
            for (Map.Entry<String, String[]> e : map.entrySet()) {
                System.out.println(e.getKey() + " " + e.getValue()[0]);
            }

            RestTemplate template = new TolerantRestTemplate();
            CandidateOutEntity candidateOutEntity = new CandidateOutEntity(auth, map.get("cnp")[0], map.get("nume")[0],map.get("prenume")[0], map.get("telefon")[0]);

            return template.postForEntity(
                    ServerProperties.middleUrl + "/save_candidate",
                    candidateOutEntity, SuccessReasonEntity.class);

        }
    }

    @RequestMapping(value = "/form_submit", method = RequestMethod.POST)
    public ResponseEntity<SuccessReasonEntity> submitForm(HttpServletRequest req){
        AuthEntity auth = AuthEntity.fromCookies(req.getCookies());
        if(auth == null){
            return new ResponseEntity<SuccessReasonEntity>(
                    new SuccessReasonEntity(false, "redirect:/login"),
                    HttpStatus.UNAUTHORIZED);
        }
        else {
            Map<String, String[]> map = req.getParameterMap();
            for (Map.Entry<String, String[]> e : map.entrySet()) {
                System.out.println(e.getKey() + " " + Arrays.toString(e.getValue()));
            }

            Map<String, String> asSingle = Mapper.changeToSingle(map);

            RestTemplate template = new TolerantRestTemplate();

            return template.postForEntity(
                    ServerProperties.middleUrl + "/submit_form",
                    new FormOutEntity(auth, asSingle), SuccessReasonEntity.class);
        }
    }

    @RequestMapping(value = "/form_save", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<SuccessReasonEntity> saveForm(HttpServletRequest req) {
        AuthEntity auth = AuthEntity.fromCookies(req.getCookies());
        //reqquest candidat info
        if (auth == null){
            return new ResponseEntity<SuccessReasonEntity>(
                    new SuccessReasonEntity(false, "redirect:/login"),
                    HttpStatus.UNAUTHORIZED);
        }
        else {
            Map<String, String[]> map = req.getParameterMap();
            for (Map.Entry<String, String[]> e : map.entrySet()) {
                System.out.println(e.getKey() + " " + Arrays.toString(e.getValue()));
            }

            Map<String, String> asSingle = Mapper.changeToSingle(map);

            RestTemplate template = new TolerantRestTemplate();

            try {
                ResponseEntity<SuccessReasonEntity> result = template.postForEntity(
                        ServerProperties.middleUrl + "/save_form",
                        new FormOutEntity(auth, asSingle),
                        SuccessReasonEntity.class);
                if (result.getStatusCode() == HttpStatus.OK){
                    return new ResponseEntity<>(result.getBody(), HttpStatus.OK);
                }
                return new ResponseEntity<>(
                        new SuccessReasonEntity(false, "Internal Server Error: bad status code."),
                        HttpStatus.BAD_REQUEST
                );
            }
            catch(RestClientException ex){
                System.out.println(ex.toString());
                return new ResponseEntity<>(
                        new SuccessReasonEntity(false,"Failed to save form."),
                        HttpStatus.BAD_REQUEST);
            }

        }
    }
}
