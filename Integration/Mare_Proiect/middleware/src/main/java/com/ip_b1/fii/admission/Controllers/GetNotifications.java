package com.ip_b1.fii.admission.Controllers;

import com.ip_b1.fii.admission.DTO.AuthEntity;
import com.ip_b1.fii.admission.DTO.NotificationEntity;
import com.ip_b1.fii.admission.DTO.NotificationsOutEntity;
import com.ip_b1.fii.admission.ServerProperties;
import com.ip_b1.fii.admission.Utils.AuthUtils;
import com.ip_b1.fii.admission.Utils.NotificationUtils;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

@RestController
@RequestMapping("/controller/get_notifications")
public class GetNotifications {
    @RequestMapping(value="count_unread", method = RequestMethod.POST)
    public ResponseEntity<Integer> getCountUnread(@RequestBody AuthEntity auth) {
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

            int unread = 0;
            for (NotificationEntity ent : entity.getBody()){
                if (!ent.isSeen()){
                    unread++;
                }
            }

            return new ResponseEntity<>(
                    unread,
                    HttpStatus.OK
            );
        }
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<List<NotificationEntity>> run(@RequestBody AuthEntity auth) {
        if (!AuthUtils.checkAuth(auth)) {
            return new ResponseEntity<>(
                    HttpStatus.UNAUTHORIZED
            );
        } else {
            RestTemplate template = new RestTemplate();
            System.out.println("Se cer notificari pentru: " + auth.getUsername());
            ResponseEntity<List<NotificationEntity>> entity = template.exchange(
                    ServerProperties.modelUrl + "/notificari/{useremail}",
                    HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<List<NotificationEntity>>() {},
                    Base64.getEncoder().encodeToString(auth.getUsername().getBytes())
            );

            for(int i = 0; i < entity.getBody().size(); i++)
                System.out.println(entity.getBody().get(i).getMessage());

            if (entity.getBody() == null) {
                return new ResponseEntity<>(
                    HttpStatus.NO_CONTENT
                );
            }

//            List<NotificationsOutEntity> outList = new ArrayList<>();
//            for (NotificationEntity ent : entity.getBody()){
//                outList.add(new NotificationsOutEntity(ent.getMessage(), ent.isSeen()));
//            }

            NotificationUtils.markSeenNotifications(auth);

            return new ResponseEntity<>(
                    entity.getBody(),
                    HttpStatus.OK
            );
        }
    }

}