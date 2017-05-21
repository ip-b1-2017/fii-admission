package fiiadmission.view.controller;

import com.sun.deploy.net.HttpResponse;
import fiiadmission.ServerProperties;
import fiiadmission.dto.AuthEntity;
import fiiadmission.dto.ClassroomEntity;
import fiiadmission.dto.ProfessorEntity;
import fiiadmission.dto.SuccessReasonEntity;
import io.swagger.models.Model;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
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

@Controller
public class AdminController {

    IValidator validator = new Validator();

    @RequestMapping(value = "/teachers_operation", method = RequestMethod.GET)
    public ModelAndView teachersOperation(HttpServletRequest req){
        Map map = req.getParameterMap();

        Map<String, String> test = Mapper.changeToSingle(map);
        RestTemplate template = new RestTemplate();
        if (test.get("button").equals("delete")) {
            ResponseEntity<SuccessReasonEntity> nume = template.postForEntity(ServerProperties.middleUrl + "/remove_professor",
                    test.get("pcnp"), SuccessReasonEntity.class);
            return new ModelAndView("redirect:/teachers");
        }
        if (test.get("button").equals("add")) {
            test.remove("button");
            ResponseEntity<SuccessReasonEntity> nume = template.postForEntity(ServerProperties.middleUrl + "/add_professor",
                    test, SuccessReasonEntity.class);
            return new ModelAndView("redirect:/teachers");
        }

        if (test.get("button").equals("see teachers")) {
            ResponseEntity<List<ProfessorEntity>> professorResponse =
                    template.exchange(ServerProperties.middleUrl + "/get_professors",
                            HttpMethod.POST, null, new ParameterizedTypeReference<List<ProfessorEntity>>() {
                            });
            List<ProfessorEntity> professors = professorResponse.getBody();
            ModelAndView modelAndView = new ModelAndView("/tabel_profesori");
            modelAndView.addObject("teachers", professors);

            return modelAndView;
        }

        return  new ModelAndView("redirect:/teachers");
    }

    @RequestMapping(value = "/classroom_operations", method = RequestMethod.GET)
    public ModelAndView classroom_operations(HttpServletRequest req){
        Map map = req.getParameterMap();

        Map<String, String> test = Mapper.changeToSingle(map);
        RestTemplate template = new RestTemplate();
        if (test.get("button").equals("Stergere clasa")) {
            ResponseEntity<SuccessReasonEntity> nume = template.postForEntity(ServerProperties.middleUrl + "/remove_classroom",
                    test.get("id"), SuccessReasonEntity.class);
            return new ModelAndView("redirect:/classroom");
        }
        if (test.get("button").equals("Adaugare clasa")) {
            test.remove("button");
            ResponseEntity<SuccessReasonEntity> nume = template.postForEntity(ServerProperties.middleUrl + "/add_classroom",
                    test, SuccessReasonEntity.class);
            return new ModelAndView("redirect:/classroom");
        }

        if (test.get("button").equals("Vizualizare sali")) {
            ResponseEntity<List<ClassroomEntity>> classroomResponse =
                    template.exchange(ServerProperties.middleUrl + "/get_classrooms",
                            HttpMethod.POST, null, new ParameterizedTypeReference<List<ClassroomEntity>>() {
                            });
            List<ClassroomEntity> classrooms = classroomResponse.getBody();
            ModelAndView modelAndView = new ModelAndView("/classroom_table");
            modelAndView.addObject("classrooms", classrooms);

            return modelAndView;
        }

        return  new ModelAndView("redirect:/classroom");
    }

    @RequestMapping(value = "/candidates_admin", method = RequestMethod.GET)
    public ModelAndView loadTable(String error, org.springframework.ui.Model model, HttpServletRequest req, HttpServletResponse rep) throws IOException {
        AuthEntity auth = AuthEntity.fromCookies(req.getCookies());
        if (auth == null){
            return new ModelAndView("redirect:/login");
        }

        RestTemplate template = new RestTemplate();
        ResponseEntity<List<CandidatForm>> candidatResponse;
        candidatResponse = template.exchange(ServerProperties.middleUrl + "/get_applications",
                HttpMethod.POST,
                new HttpEntity<>(auth),
                new ParameterizedTypeReference<List<CandidatForm>>() {}
                );
        List<CandidatForm> candidates = candidatResponse.getBody();

        ModelAndView modelAndView = new ModelAndView("/candidates_admin");
        modelAndView.addObject("candidates", candidates);

        return modelAndView;
    }

    @RequestMapping(value = "/candidates_view_form", method = RequestMethod.GET)
    public void loadFormForCNP(@RequestParam("cnp") String cnp) throws IOException {
            System.out.println("CNPul este: " + cnp);
        /*AuthEntity auth = AuthEntity.fromCookies(req.getCookies());
        if (auth == null){
            return new ModelAndView("redirect:/login");
        }
        RestTemplate template = new RestTemplate();
        ResponseEntity<List<CandidatForm>> candidatResponse;
        candidatResponse = template.exchange(ServerProperties.middleUrl + "/get_applications",
                HttpMethod.POST,
                new HttpEntity<>(auth),
                new ParameterizedTypeReference<List<CandidatForm>>() {}
        );
        List<CandidatForm> candidates = candidatResponse.getBody();

        ModelAndView modelAndView = new ModelAndView("/candidates_admin");
        modelAndView.addObject("candidates", candidates);

        return modelAndView;*/
    }
}
