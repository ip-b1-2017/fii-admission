package com.ip_b1.fii.admission.ModelStubs;

import com.ip_b1.fii.admission.DTO.NotificationsOutEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Base64;

@RestController
public class GetNotificationsStub {

    @RequestMapping(value = "notificari/{userEmail}", method = RequestMethod.GET)
    ResponseEntity<NotificationsOutEntity> run(@PathVariable("userEmail") String userEmail) {

        String base64Decoded = new String(Base64.getDecoder().decode(userEmail.getBytes()));

        if(!base64Decoded.equals("alexd@info.uaic.ro")) {
            NotificationsOutEntity result = new NotificationsOutEntity();
            String notifications = "Notification1\nNotification2\nNotification3";
            result.setNotifications(notifications);
            return new ResponseEntity<>(
                    result,
                    HttpStatus.OK
            );
        } else {
            return new ResponseEntity<>(
                    HttpStatus.NOT_FOUND
            );
        }
    }
}
