package fiiadmission.view.controller;

import fiiadmission.ServerProperties;
import fiiadmission.TolerantRestTemplate;
import fiiadmission.dto.AuthEntity;
import fiiadmission.dto.FormOutEntity;
import fiiadmission.dto.SuccessReasonEntity;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import validator.IValidator;
import validator.Mapper;
import validator.Validator;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


/**
 * Created by rusub on 5/12/2017.
 */

@Controller
@RequestMapping("/{sesion}")
public class SessionController {

    IValidator validator = new Validator();

    @RequestMapping(value = "", method = RequestMethod.GET)
    public void mainPage(@PathVariable("sesion") String session){
        //send info about form or statistics
    }

    /*@RequestMapping(value = "/form", method = RequestMethod.GET)
    public void seeForm(@PathVariable("sesion") String session,
                        HttpServletRequest req){
        if(req.getCookies() == null){
            //access denied;
        }
        else{
            //return form;
        }
    }*/

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
    public ModelAndView saveForm(HttpServletRequest req) {
        AuthEntity auth = AuthEntity.fromCookie(req.getCookies());
        if (auth == null){
            return new ModelAndView("redirect:/login");
        }
        else {
            Map<String, String[]> map = req.getParameterMap();
            for (Map.Entry<String, String[]> e : map.entrySet()) {
                System.out.println(e.getKey() + " " + Arrays.toString(e.getValue()));
            }

            Map<String, String> asSingle = Mapper.changeToSingle(map);

            RestTemplate template = new TolerantRestTemplate();
            ResponseEntity<SuccessReasonEntity> result = template.postForEntity(
                    ServerProperties.middleUrl + "/controller/save_form",
                    new FormOutEntity(auth, asSingle), SuccessReasonEntity.class);

            //TODO: respond differently to errors...
            //TODO: send the SuccessReason back

            return null;
        }
    }


}
