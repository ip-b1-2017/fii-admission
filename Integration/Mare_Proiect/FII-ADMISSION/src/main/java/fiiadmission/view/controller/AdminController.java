package fiiadmission.view.controller;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import validator.IValidator;
import validator.Validator;

import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
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
}
