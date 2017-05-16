package fiiadmission.view.controller;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

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
}
