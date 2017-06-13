package fiiadmission.view.controller;

import fiiadmission.ServerProperties;
import fiiadmission.TolerantRestTemplate;
import fiiadmission.dto.AuthEntity;
import fiiadmission.dto.Mark;
import fiiadmission.dto.MarkPostStructure;
import fiiadmission.dto.SuccessReasonEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import javax.management.BadAttributeValueExpException;
import javax.servlet.http.HttpServletRequest;

@Controller
public class MarksController {
    @RequestMapping(value="/marks", method= RequestMethod.GET)
    public ModelAndView dashboardAdmin(Model model, HttpServletRequest req){
        return new ModelAndView("/marks");
    }

    @RequestMapping(value="/marks", method= RequestMethod.POST)
    public ModelAndView dashboardAdminAddMark(Model model, HttpServletRequest req){
        AuthEntity authEntity = AuthEntity.fromCookies(req.getCookies());
        MarkPostStructure markStructure = new MarkPostStructure();
        markStructure.setEntity(authEntity);
        Mark mark = new Mark();
        try {
            mark.setCandidatCNP(req.getParameter("cnp"));
            mark.setExamenid(req.getParameter("examen"));
            mark.setValoare(Float.parseFloat(req.getParameter("mark")));

            if(!isValid(mark.getCandidatCNP()) || !isValid(mark.getExamenid()))
                throw new IllegalArgumentException("Invalid examen or cnp");
            markStructure.setMark(mark);

            RestTemplate template = new TolerantRestTemplate();

            ResponseEntity result = template.postForEntity(
                    ServerProperties.middleUrl + "/note/addValue",
                    markStructure, ResponseEntity.class);

            if(!result.getStatusCode().equals(HttpStatus.CREATED))
                throw new BadAttributeValueExpException("There was an error on middleware(or database server)");
        }catch (Exception ex){
            System.out.println("[error]@/marks - POST " + ex);
            //TODO treat error
        }
        return new ModelAndView("/marks");
    }

    private boolean isValid(String str){
        if(str == null || "".equals(str))
            return false;
        return true;
    }
}
