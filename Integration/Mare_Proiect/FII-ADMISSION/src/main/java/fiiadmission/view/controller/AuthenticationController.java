package fiiadmission.view.controller;

import fiiadmission.ServerProperties;
import fiiadmission.TolerantRestTemplate;
import fiiadmission.dto.Login;
import fiiadmission.dto.RoleEntity;
import fiiadmission.dto.SessionIdentifier;
import fiiadmission.dto.SignUpTestInEntity;
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
import java.util.HashMap;
import java.util.Map;

@Controller
public class AuthenticationController {
    private IValidator validator = new Validator();

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public @ResponseBody
    ModelAndView getLoginForm(@RequestParam(value = "error", required = false) String error,
                              Model model, HttpServletRequest req, HttpServletResponse rep) throws IOException {
        return new ModelAndView("/login");

    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView login(HttpServletRequest req, HttpServletResponse res, Model model) throws URISyntaxException, IOException {

        Map<String, String[]> params = req.getParameterMap();
        if (!validator.isValid(params)) {
            model.addAttribute("inv", "Invalid email");
            return new ModelAndView("/login");
        }
        RestTemplate rt = new RestTemplate();
        Map<String, String> singleValueParams = Mapper.changeToSingle(params);

        rt.setErrorHandler(new ResponseErrorHandler() {
            @Override
            public boolean hasError(ClientHttpResponse clientHttpResponse) throws IOException {
                return false;
            }

            @Override
            public void handleError(ClientHttpResponse clientHttpResponse) throws IOException {
            }
        });
        Login login = new Login();
        login.setUsername(singleValueParams.get("email"));
        login.setPassword(singleValueParams.get("pswall"));

        ResponseEntity<SessionIdentifier> identifier = rt.postForEntity(
                ServerProperties.middleUrl + "/login_test", login,
                SessionIdentifier.class);

        SessionIdentifier si = identifier.getBody();


        System.out.println(si.isSuccess());
        System.out.println(si.getFailureReason());
        if (!si.isSuccess()) {
            model.addAttribute("failure", si.getFailureReason());
            return new ModelAndView("/login");
        }

        Cookie cookie1 = new Cookie("user-name", singleValueParams.get("email"));
        Cookie cookie2 = new Cookie("user-token", si.getToken());
        cookie1.setSecure(true);
        cookie2.setSecure(true);

        Map<String, String> urlParams = new HashMap<String, String>();
        urlParams.put("token", si.getToken());
        ResponseEntity<RoleEntity> role = rt.getForEntity(ServerProperties.middleUrl + "/get_role/{token}", RoleEntity.class, urlParams);

        res.addCookie(cookie1);
        res.addCookie(cookie2);
        if (role.getBody().getRole().equals("user")) {
            return new ModelAndView("redirect:/dashboard");
        } else {
            return new ModelAndView("redirect:/dashboard_admin");
        }
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public ModelAndView getAuthenticationFormular(HttpServletResponse res) {
        return new ModelAndView("/register");
    }


    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public ModelAndView createAccount(String error, Model model, HttpServletRequest req, HttpServletResponse rep) {

        Map params = req.getParameterMap();

        Map singleValueParams;


        Map<String, String[]> paramss = req.getParameterMap();
        if (!validator.isValid(paramss)) {

            model.addAttribute("inv", "Invalid email");
            return new ModelAndView("/register");
        }

        try {
            singleValueParams = Mapper.changeToSingle(params);
        } catch (IllegalArgumentException ex) {
            System.out.println(ex);
            return null;
        }

        if (!singleValueParams.get("pswall").equals(singleValueParams.get("cpswall"))) {
            model.addAttribute("match", "These passwords don't match. Try again?");
            return new ModelAndView("/register");
        }
        RestTemplate rt = new TolerantRestTemplate();

        SignUpTestInEntity sign_Up = new SignUpTestInEntity();
        sign_Up.setEmail((String) singleValueParams.get("email"));
        sign_Up.setPswall((String) singleValueParams.get("pswall"));
        ResponseEntity<SignUpResponse> responseSignUp = rt.postForEntity(ServerProperties.middleUrl + "/register", sign_Up, SignUpResponse.class);


        if (!responseSignUp.getBody().isSuccess()) {
            model.addAttribute("error", responseSignUp.getBody().getFailureReason());
            return new ModelAndView("/register");
        } else {
            try {
                rep.sendRedirect("/login");
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
    }


    @RequestMapping(value = "/disconnect", method = RequestMethod.GET)
    public ModelAndView delete(HttpServletRequest request, HttpServletResponse response) {

        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            cookie.setMaxAge(0);
            cookie.setValue(null);
            cookie.setPath("/");
            response.addCookie(cookie);

        }
        return new ModelAndView("redirect:/login");
    }
}