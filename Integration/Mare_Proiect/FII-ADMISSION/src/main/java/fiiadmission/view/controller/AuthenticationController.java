package fiiadmission.view.controller;

import fiiadmission.ServerProperties;
import fiiadmission.dto.SessionIdentifier;
import fiiadmission.view.Model.SignUpResponse;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.ResponseErrorHandler;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import validator.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Map;

/**
 * Created by rusub on 5/6/2017.
 */
@Controller
public class AuthenticationController{
    private IValidator validator = new Validator();

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public @ResponseBody ModelAndView getLoginForm(@RequestParam(value="error", required=false) String error,
            Model model, HttpServletRequest req, HttpServletResponse rep) throws IOException {
        if(req.getCookies() != null){
            rep.sendRedirect("/login");
            return null;
        }
        else{
            model.addAttribute("error", error);
            //return null;
            return new ModelAndView("/login");
        }
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public void login(HttpServletRequest req,
                      HttpServletResponse res) throws URISyntaxException {
        if (req.getCookies() != null) {
            for (Cookie cookie : req.getCookies())
                System.out.println(cookie.getName() + " " + cookie.getValue());
        }

        Map<String, String[]> params = req.getParameterMap();
        if(!validator.isValid(params)){
            //wrong input parameters
            //TODO: return a html to inform user
            return;
        }
        RestTemplate rt = new RestTemplate();
        Map singleValueParams = Mapper.changeToSingle(params);
        //TODO test the returning result
        SessionIdentifier si = rt.postForEntity(
                ServerProperties.middleUrl + "/login_test", singleValueParams,
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
    public ModelAndView createAccount(String error, Model model, HttpServletRequest req, HttpServletResponse rep) {

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

        rt.setErrorHandler(new ResponseErrorHandler() {
            @Override
            public boolean hasError(ClientHttpResponse clientHttpResponse) throws IOException {
                return false;
            }

            @Override
            public void handleError(ClientHttpResponse clientHttpResponse) throws IOException {

            }
        });

        System.out.println("reasda");
        ResponseEntity<SignUpResponse> responseSignUp = rt.postForEntity(ServerProperties.middleUrl + "/register", singleValueParams,SignUpResponse.class);

        System.out.println(responseSignUp.getBody().getFailureReason());

        if (!responseSignUp.getBody().isSuccess()) {
            model.addAttribute("error", error);
            return new ModelAndView("/register");
        }else {
            try {
                rep.sendRedirect("/login");
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
    }
}