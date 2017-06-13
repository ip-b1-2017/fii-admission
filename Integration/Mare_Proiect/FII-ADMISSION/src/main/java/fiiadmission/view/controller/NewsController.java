package fiiadmission.view.controller;


import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by cosmin on 6/13/2017.
 */
@Controller
public class NewsController {
    @RequestMapping(value="/news", method= RequestMethod.GET)
    public ModelAndView dashboardAdmin(Model model, HttpServletRequest req) {
        return new ModelAndView("/news");
    }
}
