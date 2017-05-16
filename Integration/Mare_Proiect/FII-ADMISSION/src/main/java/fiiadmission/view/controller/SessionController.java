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




}
