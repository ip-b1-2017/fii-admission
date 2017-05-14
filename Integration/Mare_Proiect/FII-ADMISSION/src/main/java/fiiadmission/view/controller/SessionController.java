package fiiadmission.view.controller;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import validator.IValidator;
import validator.Mapper;
import validator.Validator;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Map;


/**
 * Created by rusub on 5/12/2017.
 */

@Controller
@RequestMapping("/{session}")
public class SessionController {

    IValidator validator = new Validator();

    @RequestMapping(value = "", method = RequestMethod.GET)
    public void mainPage(@PathVariable("session") String session){
        //send info about form or statistics
    }

    @RequestMapping(value = "/form", method = RequestMethod.GET)
    public void seeForm(@PathVariable("session") String session,
                        HttpServletRequest req){
        if(req.getCookies() == null){
            //access denied;
        }
        else{
            //return form;
        }
    }

    @RequestMapping(value = "/form_save", method = RequestMethod.POST)
    public void saveForm(HttpServletRequest req){
        if(req.getCookies() != null){
            //access denied
        }
        else{
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
            //save form
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

    @RequestMapping(value = "/delete_teacher", method = RequestMethod.GET)
    public ModelAndView getTeachers(HttpServletRequest req, HttpServletResponse rep){
        return new ModelAndView("profesori");
    }


}
