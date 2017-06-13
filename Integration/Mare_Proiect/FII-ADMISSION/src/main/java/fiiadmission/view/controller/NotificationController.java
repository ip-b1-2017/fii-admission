package fiiadmission.view.controller;


import fiiadmission.ServerProperties;
import fiiadmission.dto.AuthEntity;
import fiiadmission.dto.Email;
import fiiadmission.dto.NotificationEntity;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class NotificationController {
    @RequestMapping(path="/notifications", method=RequestMethod.GET)
    public @ResponseBody
    ModelAndView getDashboard(String error, Model model, HttpServletRequest req, HttpServletResponse rep) throws IOException {
        AuthEntity auth = AuthEntity.fromCookies(req.getCookies());
        if (auth == null){
            rep.sendError(400, "Unauthenticated.");
            return null;
        }
        Email email = new Email();
        email.setEmail(auth.getUsername());
        List<NotificationEntity> notifications = getNotifications(auth);

        if (notifications == null){
            rep.sendError(400, "Bad authentication.");
            return null;
        }
        int notifsUnread = 0;
        for (NotificationEntity notif : notifications) {
            if (!notif.isRead()){
                notifsUnread++;
            }
        }

        model.addAttribute("user_name",auth.getUsername());
        model.addAttribute("notifications", notifications);
        model.addAttribute("unread_notifications", notifsUnread);
        return new ModelAndView("/notifications");
    }

    public static List<NotificationEntity> getNotifications(AuthEntity auth) {
        RestTemplate restTemplate = new RestTemplate();
        try {
            ResponseEntity<List<NotificationEntity>> results = restTemplate.exchange(
                    ServerProperties.middleUrl + "/get_notifications",
                    HttpMethod.POST,
                    new HttpEntity<>(auth),
                    new ParameterizedTypeReference<List<NotificationEntity>>() {
                    }
            );
            if (results.getBody() == null) {
                return new ArrayList<>();
            }
            return results.getBody();
        }
        catch(RestClientResponseException ex){
            ex.printStackTrace();
            return null;
        }
    }
}
