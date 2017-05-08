package fiiadmission.view.controller;

import fiiadmission.dto.LoginDTO;
import fiiadmission.view.Model.RegisterDTO;
import fiiadmission.view.Model.SessionIdentifier;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import validator.BodyParser;
import validator.IBodyParser;
import validator.IValidator;
import validator.Validator;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * Created by rusub on 5/6/2017.
 */
@RestController
public class AuthenticationController{

    //TODO fill URL and REGISTER_URL with corresponding urls
    private static final String URL = "";
    private static final String REGISTER_URL = "";
    private IValidator validator = new Validator();

    @Autowired
    private HttpServletRequest request;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public void getLoginFormular(HttpServletRequest req, HttpServletResponse rep){
        if(req.getCookies() != null){
            /*
                username already login
                TODO: redirect to another page
             */
        }
        else{
            rep.addCookie(new Cookie("name", "value"));
            //TODO: return here login formular to user
        }
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public void login(@RequestBody  String body,
                      HttpServletResponse res
                        ) throws URISyntaxException {
        if(!validator.isValid(body)){
            //wrong input parameters
            //TODO: return a html to inform user
            return;
        }
        RestTemplate rt = new RestTemplate();
        IBodyParser parser = new BodyParser(body);
        LoginDTO dto = new LoginDTO();
        dto.setUsername(parser.next()[1]);
        dto.setPassword(parser.next()[1]);
        //TODO test the returning result
        SessionIdentifier si = rt.postForEntity(
                new URI(URL), dto,
                SessionIdentifier.class).getBody();
        Cookie cookie1 = new Cookie("user-name", si.getUsername());
        Cookie cookie2 = new Cookie("user-token", si.getToken());
        cookie1.setSecure(true);
        cookie2.setSecure(true);
        res.addCookie(cookie1);
        res.addCookie(cookie2);
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public void getAuthenticationFormular(){
        //TODO return formular
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public void createAccount(@RequestBody String body){

        if(!validator.isValid(body)){
            //TODO: tell user via html error code or javascript modal window
        }
        RegisterDTO auth = new RegisterDTO();
        IBodyParser parser = new BodyParser(body);
        auth.setFirstName(parser.next()[1]);
        auth.setLastName(parser.next()[1]);
        auth.setEmail(parser.next()[1]);
        auth.setPassword(parser.next()[1]);
        auth.setCNP(Long.parseLong(parser.next()[1]));

        RestTemplate rt = new RestTemplate();
        ResponseEntity res = rt.postForObject(REGISTER_URL, auth, ResponseEntity.class);
        //TODO test res http status for sending back to user a feedback
    }
}
