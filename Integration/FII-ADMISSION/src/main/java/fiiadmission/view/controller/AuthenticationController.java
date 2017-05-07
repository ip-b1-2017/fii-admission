package fiiadmission.view.controller;

import fiiadmission.dto.LoginDTO;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import validator.BodyParser;
import validator.IBodyParser;
import validator.IValidator;
import validator.Validator;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * Created by rusub on 5/6/2017.
 */
@RestController
@RequestMapping("/login")
public class AuthenticationController{

    private static final String URL = "";
    private IValidator validator = new Validator();
    private IBodyParser parser = new BodyParser();
    @Autowired
    private HttpServletRequest request;

    @RequestMapping(method = RequestMethod.GET)
    public void getLoginFormular(){
        //return here login formular to user
    }

    @RequestMapping(method = RequestMethod.POST)
    public void login(@RequestBody  String body) throws URISyntaxException {
        System.out.println(body);
        if(!validator.isValid(body)){
            //wrong input parameters
            //return a html to inform user
            return;
        }
        RestTemplate rt = new RestTemplate();
        parser.setBody(body);
        LoginDTO dto = new LoginDTO();
        dto.setUsername(parser.next()[1]);
        dto.setUsername(parser.next()[1]);
        System.out.println(dto.getUsername() + " " + dto.getPassword());
        rt.postForLocation(new URI(URL), dto);
    }
}
