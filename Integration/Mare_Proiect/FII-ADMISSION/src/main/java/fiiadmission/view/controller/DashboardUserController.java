package fiiadmission.view.controller;

import fiiadmission.ServerProperties;
import fiiadmission.dto.AuthEntity;
import fiiadmission.dto.Email;
import fiiadmission.dto.NotificationEntity;
import fiiadmission.dto.StatisticiUser;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Controller
public class DashboardUserController {

    @RequestMapping(value = "/dashboard", method = RequestMethod.GET)
    public @ResponseBody
    ModelAndView getDashboard(String error, Model model, HttpServletRequest req, HttpServletResponse rep) throws IOException {
        AuthEntity auth = AuthEntity.fromCookies(req.getCookies());
        if (auth == null){
            rep.sendError(400, "Unauthenticated.");
            return null;
        }
        Email email = new Email();
        email.setEmail(auth.getUsername());
        StatisticiUser statisticiUser = getStatisticiUser(email);
        Integer notificationsCountUnread = getNotificationsCountUnread(auth);

        if (statisticiUser == null || notificationsCountUnread == null){
            rep.sendError(400, "Bad authentication.");
            return null;
        }

        model.addAttribute("nr_aplicatii_depuse", statisticiUser.getNumarAplicanti());
        model.addAttribute("status_aplicatie",statisticiUser.getStatusAplicatie());
        model.addAttribute("user_name",auth.getUsername());
        model.addAttribute("unread_notifications", notificationsCountUnread);
        return new ModelAndView("/dashboard");
    }

    public static Integer getNotificationsCountUnread(AuthEntity auth) {
        RestTemplate restTemplate = new RestTemplate();
        try {
            ResponseEntity<Integer> results = restTemplate.exchange(
                    ServerProperties.middleUrl + "/get_notifications/count_unread",
                    HttpMethod.POST,
                    new HttpEntity<>(auth),
                    Integer.class
            );
            if (results.getBody() == null) {
                return 0;
            }
            return results.getBody();
        }
        catch(RestClientResponseException ex){
            ex.printStackTrace();
            return null;
        }
    }

    private StatisticiUser getStatisticiUser(Email email){
        RestTemplate restTemplate = new RestTemplate();

        try {
            ResponseEntity<StatisticiUser> response = restTemplate.postForEntity(
                    ServerProperties.middleUrl + "/statistici/get_statistici_user",
                    email,
                    StatisticiUser.class
            );
            return response.getBody();
        }
        catch(RestClientResponseException ex){
            ex.printStackTrace();
            return null;
        }
    }

}
