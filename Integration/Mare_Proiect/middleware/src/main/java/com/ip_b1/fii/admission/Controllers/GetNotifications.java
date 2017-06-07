package com.ip_b1.fii.admission.Controllers;

import com.ip_b1.fii.admission.DTO.AuthEntity;
import com.ip_b1.fii.admission.DTO.NotificationEntity;
import com.ip_b1.fii.admission.DTO.NotificationsOutEntity;
import com.ip_b1.fii.admission.ServerProperties;
import com.ip_b1.fii.admission.Utils.AuthUtils;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

@RestController
@RequestMapping("/controller/get_notifications")
public class GetNotifications {
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<List<String>> run(@RequestBody AuthEntity auth) {
        if (!AuthUtils.checkAuth(auth)) {
            return new ResponseEntity<>(
                    HttpStatus.UNAUTHORIZED
            );
        } else {
            RestTemplate template = new RestTemplate();

            ResponseEntity<List<NotificationEntity>> entity = template.exchange(
                    ServerProperties.modelUrl + "/notificari/{useremail}",
                    HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<List<NotificationEntity>>() {},
                    Base64.getEncoder().encodeToString(auth.getUsername().getBytes())
            );
            if (entity.getBody() == null) {
                return new ResponseEntity<>(
                    HttpStatus.NO_CONTENT
                );
            }

            List<String> notificationStrings = new ArrayList<>();
            for (NotificationEntity ent : entity.getBody()){
                notificationStrings.add(ent.getMessage());
            }

            return new ResponseEntity<List<String>>(
                    notificationStrings,
                    HttpStatus.OK
            );
        }
    }

}
