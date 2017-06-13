package com.ip_b1.fii.admission.Controllers;

import com.ip_b1.fii.admission.DTO.NotificationEntity;
import com.ip_b1.fii.admission.DTO.NotificationSendEntity;
import com.ip_b1.fii.admission.DTO.SuccessEntity;
import com.ip_b1.fii.admission.Utils.AuthUtils;
import com.ip_b1.fii.admission.Utils.NotificationUtils;
import com.ip_b1.fii.admission.Utils.UserUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/controller/send_notification")
public class SendNotification {
    @RequestMapping(method= RequestMethod.POST)
    public ResponseEntity<SuccessEntity> sendNotification(@RequestBody NotificationSendEntity notification) {
        if (!AuthUtils.checkAuth(notification.getAuth())){
            return new ResponseEntity<SuccessEntity>(HttpStatus.UNAUTHORIZED);
        }

        String email = UserUtils.getUsernameFromCnp(notification.getCnp());

        if (!NotificationUtils.pushNotification(email, notification.getMessage())){
            return new ResponseEntity<SuccessEntity>(new SuccessEntity(false), HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<SuccessEntity>(new SuccessEntity(true), HttpStatus.OK);
    }

}
