package fiiadmission.view.controller;

import fiiadmission.ServerProperties;
import fiiadmission.dto.AuthEntity;
import fiiadmission.dto.Email;
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
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by cosmin on 5/16/2017.
 */
@Controller
public class DashboardUserController {

    @RequestMapping(value = "/dashboard", method = RequestMethod.GET)
    public @ResponseBody
    ModelAndView getLoginForm( String error, Model model, HttpServletRequest req, HttpServletResponse rep) throws IOException {
        AuthEntity auth = AuthEntity.fromCookies(req.getCookies());
        Email email = new Email();
        email.setEmail(auth.getUsername());
        StatisticiUser statisticiUser = getStatisticiUser(email);

        model.addAttribute("nr_aplicatii_depuse", statisticiUser.getNumarAplicanti());
        model.addAttribute("status_aplicatie",statisticiUser.getStatusAplicatie());
        model.addAttribute("user_name",auth.getUsername());
        model.addAttribute("notifications", getNotifications(auth));
        return new ModelAndView("/dashboard");
    }

    private List<String> getNotifications(AuthEntity auth) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<String>> results = restTemplate.exchange(
                ServerProperties.middleUrl + "/get_notifications",
                HttpMethod.POST,
                new HttpEntity<>(auth),
                new ParameterizedTypeReference<List<String>>() {}
        );
        if (results.getBody() == null){
            return new ArrayList<>();
        }
        return results.getBody();
    }

    private StatisticiUser getStatisticiUser(Email email){
        RestTemplate restTemplate = new RestTemplate();
        /*
        restTemplate.setErrorHandler(new ResponseErrorHandler() {
            @Override
            public boolean hasError(ClientHttpResponse clientHttpResponse) throws IOException {
                return false;
            }

            @Override
            public void handleError(ClientHttpResponse clientHttpResponse) throws IOException {

            }
        });*/
        ResponseEntity<StatisticiUser> response = restTemplate.postForEntity(
                ServerProperties.middleUrl + "/statistici/get_statistici_user",
                email,
                StatisticiUser.class
        );
        return response.getBody();
    }

}
