package fiiadmission.view.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MarksController {
    @RequestMapping(value="/marks", method= RequestMethod.GET)
    public ModelAndView dashboardAdmin(Model model, HttpServletRequest req){
        return new ModelAndView("/marks");
    }
}
