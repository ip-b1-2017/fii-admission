package fiiadmission.view.controller;

import com.sun.deploy.net.HttpResponse;
import fiiadmission.ServerProperties;
import fiiadmission.dto.ProfessorEntity;
import fiiadmission.dto.SuccessReasonEntity;
import io.swagger.models.Model;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import validator.IValidator;
import validator.Mapper;
import validator.Validator;
import fiiadmission.view.Model.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Created by rusub on 5/14/2017.
 */
@Controller
public class AdminController {

    IValidator validator = new Validator();

    @RequestMapping(value = "/operation", method = RequestMethod.POST)
    public ModelAndView operation(HttpServletRequest req){
        Map map = req.getParameterMap();

        Map<String, String> test = Mapper.changeToSingle(map);
        RestTemplate template = new RestTemplate();
        if (test.get("button").equals("delete")) {
            ResponseEntity<SuccessReasonEntity> nume = template.postForEntity(ServerProperties.middleUrl + "/remove_professor",
                    test.get("pcnp"), SuccessReasonEntity.class);
            return new ModelAndView("redirect:/delete_teacher");
        }
        if (test.get("button").equals("add")) {
            test.remove("button");
            ResponseEntity<SuccessReasonEntity> nume = template.postForEntity(ServerProperties.middleUrl + "/add_professor",
                    test, SuccessReasonEntity.class);
            return new ModelAndView("redirect:/delete_teacher");
        }

        if (test.get("button").equals("see teachers")) {
            ResponseEntity<List<ProfessorEntity>> professorResponse =
                    template.exchange(ServerProperties.middleUrl + "/get_professors",
                            HttpMethod.POST, null, new ParameterizedTypeReference<List<ProfessorEntity>>() {
                            });
            List<ProfessorEntity> professors = professorResponse.getBody();
            return new ModelAndView("redirect:/tabel_profesori");
        }

        return  new ModelAndView("redirect:/delete_teacher");
    }

    @RequestMapping(value = "/candidati", method = RequestMethod.GET)
    public ModelAndView loadTable(String error, org.springframework.ui.Model model, HttpServletRequest req, HttpServletResponse rep) throws IOException {
        RestTemplate template = new RestTemplate();
        ResponseEntity<List<CandidatForm>> candidatResponse;
        candidatResponse = template.exchange("http://localhost:9999/model/candidati_formuri", HttpMethod.GET,
                null, new ParameterizedTypeReference<List<CandidatForm>>() {
                });
        List<CandidatForm> candidates = candidatResponse.getBody();

        model.addAttribute("message", "TEST SIMPLU!");

        List<String> list = getList();
        ModelAndView modelAndView = new ModelAndView("/tabel_candidati");
        modelAndView.addObject("lists", list);

        model.addAttribute("listValue");
        return modelAndView;
    }

    private List<String> getList() {

        List<String> list = new ArrayList<String>();
        list.add("List A");
        list.add("List B");
        list.add("List C");
        list.add("List D");
        list.add("List 1");
        list.add("List 2");
        list.add("List 3");

        return list;
    }
}
