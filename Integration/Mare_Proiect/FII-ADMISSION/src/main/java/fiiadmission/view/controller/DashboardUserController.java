package fiiadmission.view.controller;

import fiiadmission.ServerProperties;
import fiiadmission.dto.Email;
import fiiadmission.dto.StatisticiUser;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
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

/**
 * Created by cosmin on 5/16/2017.
 */
@Controller
public class DashboardUserController {

    @RequestMapping(value = "/dashboard", method = RequestMethod.GET)
    public @ResponseBody
    ModelAndView getLoginForm( String error, Model model, HttpServletRequest req, HttpServletResponse rep) throws IOException {
        Cookie[] cookies = req.getCookies();
        String emaill = null;
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("user-name")) {
                 emaill = cookie.getValue();
            }
        }
        Email email = new Email();
        email.setEmail(emaill);
        StatisticiUser statisticiUser = getStatisticiUser(email);

        model.addAttribute("nr_aplicatii_depuse", statisticiUser.getNumarAplicanti());
        model.addAttribute("status_aplicatie",statisticiUser.getStatusAplicatie());

        return new ModelAndView("/dashboard");
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
                ServerProperties.middleUrl + "/statistics/get_user_statistics",
                email,
                StatisticiUser.class
        );
        return response.getBody();
    }

}
