package fiiadmission.view.controller;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.sun.deploy.net.HttpResponse;
import fiiadmission.ServerProperties;
import fiiadmission.TolerantRestTemplate;
import fiiadmission.dto.*;
import io.swagger.models.Model;
import io.swagger.models.auth.In;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import sun.net.www.http.HttpClient;
import validator.IValidator;
import validator.Mapper;
import validator.Validator;
import fiiadmission.view.Model.*;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URL;
import java.util.*;

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

            Map<String, Object> data = new HashMap<String, Object>();
            data.put( "id", test.get("id") );
            data.put( "locatie", test.get("locatie") );
            data.put( "nr_locuri", Integer.parseInt(test.get("nr_locuri")) );

            ResponseEntity<SuccessReasonEntity> nume = template.postForEntity(ServerProperties.middleUrl + "/add_classroom",
                    data, SuccessReasonEntity.class);
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

    public static boolean pushNotification(AuthEntity auth, String cnp, String message){
        NotificationSendEntity entity = new NotificationSendEntity(auth, cnp, message);
        RestTemplate template = new TolerantRestTemplate();
        ResponseEntity<SuccessEntity> result =
                template.postForEntity(ServerProperties.middleUrl+ "/push_notification", entity, SuccessEntity.class);
        return result.getStatusCode() == HttpStatus.OK && result.getBody().isSuccess();
    }

    /// Returns if any notifications have been deleted (It is not a failure if there are no notifications)
    public static boolean clearNotifications(AuthEntity auth){
        String emailB64 = new String(Base64.getEncoder().encode(auth.getUsername().getBytes()));

        RestTemplate template = new TolerantRestTemplate();
        ResponseEntity<SuccessEntity> result = template.exchange(
                ServerProperties.modelUrl + "/notificari/{emailB64}",
                HttpMethod.DELETE,
                null,
                SuccessEntity.class,
                emailB64
        );
        return result.getStatusCode() == HttpStatus.OK && result.getBody().isSuccess();
    }

    @RequestMapping(value = "/accept_candidate", method = RequestMethod.POST)
    public ModelAndView acceptCandidateFromForm(@RequestParam("cnp") String cnp, String error,
                                        org.springframework.ui.Model model,
                                        HttpServletRequest req,
                                        HttpServletResponse rep) {

        AuthEntity auth = AuthEntity.fromCookies(req.getCookies());
        if (auth == null){
            return new ModelAndView("redirect:/login");
        }

        String comment = req.getParameter("comment");

        RestTemplate template = new RestTemplate();
        ResponseEntity<SuccessEntity> response = template.exchange(
                ServerProperties.middleUrl + "/application_review_accept/cnp=" + cnp,
                HttpMethod.POST,
                null,
                new ParameterizedTypeReference<SuccessEntity>() {
                });

        boolean result = pushNotification(auth, cnp, comment);
        System.out.println("accept_candidate -> " + result);

        return new ModelAndView("redirect:/candidates_admin");
    }

    @RequestMapping(value = "/reject_candidate", method = RequestMethod.POST)
    public ModelAndView rejectCandidateFromForm(@RequestParam("cnp") String cnp, String error,
                                                org.springframework.ui.Model model,
                                                HttpServletRequest req,
                                                HttpServletResponse rep) {

        AuthEntity auth = AuthEntity.fromCookies(req.getCookies());
        if (auth == null){
            return new ModelAndView("redirect:/login");
        }

        String comment = req.getParameter("comment");

        RestTemplate template = new RestTemplate();

        ResponseEntity<SuccessEntity> response = template.exchange(
                ServerProperties.middleUrl + "/application_review_reject/cnp=" + cnp,
                HttpMethod.POST,
                null,
                new ParameterizedTypeReference<SuccessEntity>() {
                });

        boolean result = pushNotification(auth, cnp, comment);
        System.out.println("reject_candidate -> " + result);

        return new ModelAndView("redirect:/candidates_admin");
    }



    @RequestMapping(value = "/candidates_accept", method = RequestMethod.GET)
    public ModelAndView acceptCandidate(@RequestParam("cnp") String cnp, String error,
                                        org.springframework.ui.Model model,
                                        HttpServletRequest req, HttpServletResponse rep) {
        AuthEntity auth = AuthEntity.fromCookies(req.getCookies());
        if (auth == null) {
            return new ModelAndView("redirect:/login");
        }

        RestTemplate template = new RestTemplate();
        ResponseEntity<SuccessEntity> response = template.exchange(
                ServerProperties.middleUrl + "/application_review_accept/cnp=" + cnp,
                HttpMethod.POST,
                null,
                new ParameterizedTypeReference<SuccessEntity>() {
                });

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

    @RequestMapping(value = "/candidates_reject", method = RequestMethod.GET)
    public ModelAndView rejectCandidate(@RequestParam("cnp") String cnp, String error,
                                        org.springframework.ui.Model model, HttpServletRequest req,
                                        HttpServletResponse rep) {
        AuthEntity auth = AuthEntity.fromCookies(req.getCookies());
        if (auth == null){
            return new ModelAndView("redirect:/login");
        }

        RestTemplate template = new RestTemplate();

        ResponseEntity<SuccessEntity> response = template.exchange(
                ServerProperties.middleUrl + "/application_review_reject/cnp=" + cnp,
                HttpMethod.POST,
                null,
                new ParameterizedTypeReference<SuccessEntity>() {
                });

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
    public ModelAndView loadFormForCNP(@RequestParam("cnp") String cnp,  HttpServletRequest req) throws IOException {
        AuthEntity auth = AuthEntity.fromCookies(req.getCookies());
        if (auth == null){
            return new ModelAndView("redirect:/login");
        }
        RestTemplate template = new RestTemplate();
        ResponseEntity<Map<String, String>> candidatResponse;
        candidatResponse = template.exchange(
                ServerProperties.modelUrl + "/formuri/" + cnp,
                HttpMethod.GET,
                null, new ParameterizedTypeReference<Map<String, String>>() {
                });
        Map<String, String> form = candidatResponse.getBody();
        ModelAndView model = new ModelAndView("/candidate_view_form");
        for (Map.Entry<String, String> e : form .entrySet()) {
            try {
                String att = e.getKey().replaceAll("\\-", "_");
                String val = e.getValue().replaceAll("%2B", "+");
                model.addObject(att,val);
                System.out.println("[debug][AdminController][loadForm]" + att + " " + val);
                if (val.length() > 0) {
                    model.addObject(att + "s", "#C3FDB8");
                }
            } catch (Exception e1) {
                System.out.println("@FormController@getForm : User has no form in DB currently.");
            }
        }
        model.addObject("cnp", cnp);
        return model;
    }
}
