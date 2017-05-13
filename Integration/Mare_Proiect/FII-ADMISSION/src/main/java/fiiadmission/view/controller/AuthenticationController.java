package fiiadmission.view.controller;

import fiiadmission.dto.SessionIdentifier;
import fiiadmission.view.Model.SignUpResponse;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import validator.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;

/**
 * Created by rusub on 5/6/2017.
 */
@RestController
public class AuthenticationController {

    //TODO fill URL and REGISTER_URL with corresponding urls
    private static final String URL = "";
    private static final String REGISTER_URL = "http://localhost:8081/controller/register";
    private IValidator validator = new Validator();

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public void getLoginFormular(HttpServletRequest req, HttpServletResponse rep) {
        if (req.getCookies() != null) {
            /*
                username already login
                TODO: redirect to another page
             */
        } else {
            rep.addCookie(new Cookie("name", "value"));
            //TODO: return here login formular to user
        }
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public void login(HttpServletRequest req,
                      HttpServletResponse res
    ) throws URISyntaxException {
        if (req.getCookies() != null) {
            for (Cookie cookie : req.getCookies())
                System.out.println(cookie.getName() + " " + cookie.getValue());
        }

        Map params = req.getParameterMap();
        if (!validator.isValid(params)) {
            //wrong input parameters
            //TODO: return a html to inform user
            return;
        }
        RestTemplate rt = new RestTemplate();
        Map singleValueParams = Mapper.changeToSingle(params);
        //TODO test the returning result
        SessionIdentifier si = rt.postForEntity(
                new URI(URL), singleValueParams,
                SessionIdentifier.class).getBody();
        Cookie cookie1 = new Cookie("user-name", si.getUsername());
        Cookie cookie2 = new Cookie("user-token", si.getToken());
        cookie1.setSecure(true);
        cookie2.setSecure(true);
        res.addCookie(cookie1);
        res.addCookie(cookie2);
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public void getAuthenticationFormular() {
        //TODO return formular
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public ModelAndView createAccount(HttpServletRequest req) {

        Map params = req.getParameterMap();
        /*
        if (!validator.isValid(params)) {
        }*/

        Map singleValueParams;
        System.out.println("salut");
        try {
            singleValueParams = Mapper.changeToSingle(params);
        } catch (IllegalArgumentException ex) {
            //TODO treat error;
            System.out.println(ex);
            return null;
        }
        RestTemplate rt = new RestTemplate();
        System.out.println("reasda");
        SignUpResponse responseSignUp = rt.postForObject(REGISTER_URL, singleValueParams, SignUpResponse.class);
        System.out.println(responseSignUp.getFailureReason());
        if (!responseSignUp.isSuccess()) {
                //print failure message
            return new ModelAndView("redirect:HTML/signup2.html","msg",responseSignUp.getFailureReason());
        }
        return new ModelAndView("redirect:HTML/login2.html");
    }
}
