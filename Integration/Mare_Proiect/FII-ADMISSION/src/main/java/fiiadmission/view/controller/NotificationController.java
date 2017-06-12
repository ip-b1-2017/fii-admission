package fiiadmission.view.controller;


import fiiadmission.dto.AuthEntity;
import fiiadmission.dto.Email;
import fiiadmission.dto.NotificationEntity;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
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
        List<NotificationEntity> notifications = DashboardUserController.getNotifications(auth);

        if (notifications == null){
            rep.sendError(400, "Bad authentication.");
            return null;
        }

        model.addAttribute("user_name",auth.getUsername());
        model.addAttribute("notifications", notifications);
        return new ModelAndView("/notifications");
    }
}
