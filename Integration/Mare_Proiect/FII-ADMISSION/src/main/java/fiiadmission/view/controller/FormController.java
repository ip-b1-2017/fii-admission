package fiiadmission.view.controller;

import fiiadmission.ServerProperties;
import fiiadmission.TolerantRestTemplate;
import fiiadmission.dto.AuthEntity;
import fiiadmission.dto.FormOutEntity;
import fiiadmission.dto.SuccessReasonEntity;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import validator.Mapper;

import java.util.Arrays;
import java.util.Map;

@Controller
public class FormController {
    @RequestMapping(value = "/form", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView getForm(HttpServletRequest req){
        if(req.getCookies() != null){
            return new ModelAndView("/form");
        }
        else{
            return new ModelAndView("/login");
        }
    }

    @RequestMapping(value = "/form_submit", method = RequestMethod.POST)
    public void submitForm(HttpServletRequest req){
        if(req.getCookies() == null){
            //access denied
        }
        else {
            Map form = req.getParameterMap();
            if(!validator.isValid(form)){
                //form is invalid
                //send a message to user to tell that
            }
            Map singleValueParameters;
            try {
                singleValueParameters = Mapper.changeToSingle(form);
            }catch(IllegalArgumentException ex){
                System.out.println(ex);
                return;
            }
            // submit form
        }
    }

    @RequestMapping(value = "/form_save", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<SuccessReasonEntity> saveForm(HttpServletRequest req) {
        AuthEntity auth = AuthEntity.fromCookie(req.getCookies());
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

            return template.postForEntity(
                    ServerProperties.middleUrl + "/controller/save_form",
                    new FormOutEntity(auth, asSingle), SuccessReasonEntity.class);
        }
    }
}
