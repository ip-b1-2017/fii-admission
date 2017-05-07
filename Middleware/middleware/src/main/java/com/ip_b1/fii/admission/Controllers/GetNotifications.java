package com.ip_b1.fii.admission.Controllers;

import com.ip_b1.fii.admission.DTO.AuthEntity;
import com.ip_b1.fii.admission.DTO.NotificationsOutEntity;
import com.ip_b1.fii.admission.ServerProperties;
import com.ip_b1.fii.admission.Utils.AuthUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/controller/{sessionId}/get_notifications")
public class GetNotifications {

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<NotificationsOutEntity> showNotifications(@PathVariable String sessionId, @RequestBody AuthEntity auth) {
        if (!AuthUtils.checkAuth(auth)) {
            return new ResponseEntity<>(
                    new NotificationsOutEntity(null),
                    HttpStatus.UNAUTHORIZED
            );
        } else {
            RestTemplate template = new RestTemplate();

            ResponseEntity<NotificationsOutEntity> entity = template.getForEntity(
                    ServerProperties.modelUrl + "/{sessionId}/get_notifications?username={username}",
                    NotificationsOutEntity.class,
                    sessionId,
                    auth.getUsername()
            );
            if( entity.getBody()==null)
                return new ResponseEntity<>(
                        entity.getBody(),
                        HttpStatus.NOT_FOUND

                );

            return new ResponseEntity<>(
                    entity.getBody(),
                    HttpStatus.OK
                    //
            );
        }
    }

}
