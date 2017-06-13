package com.ip_b1.fii.admission.Utils;

import com.ip_b1.fii.admission.DTO.ApplicationEntity;
import com.ip_b1.fii.admission.DTO.AuthEntity;
import com.ip_b1.fii.admission.DTO.NotificationEntity;
import com.ip_b1.fii.admission.DTO.SuccessEntity;
import com.ip_b1.fii.admission.ServerProperties;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Base64;
import java.util.List;

public class NotificationUtils {
    public static boolean pushNotification(AuthEntity auth, String message){
        NotificationEntity entity = new NotificationEntity(auth.getUsername(), false, message);

        RestTemplate template = new TolerantRestTemplate();
        ResponseEntity<SuccessEntity> result =
                template.postForEntity(ServerProperties.modelUrl + "/notificari", entity, SuccessEntity.class);
        return result.getStatusCode() == HttpStatus.OK && result.getBody().isSuccess();
    }

    /// Returns if any notifications have been deleted (It is not a failure if there are no notifications)
    public static boolean clearNotifications(AuthEntity auth){
        String emailB64 = new String(Base64.getEncoder().encode(auth.getUsername().getBytes()));

        RestTemplate template = new TolerantRestTemplate();
        ResponseEntity<SuccessEntity> result = template.exchange(
                ServerProperties.modelUrl + "/notificari/{emailB64}",
                HttpMethod.DELETE,
                null,
                SuccessEntity.class,
                emailB64
                );
        return result.getStatusCode() == HttpStatus.OK && result.getBody().isSuccess();
    }

    public static boolean markSeenNotifications(AuthEntity auth){
        String emailB64 = new String(Base64.getEncoder().encode(auth.getUsername().getBytes()));

        RestTemplate template = new TolerantRestTemplate();
        ResponseEntity<SuccessEntity> result = template.exchange(
                ServerProperties.modelUrl + "/notificari/{emailB64}/mark_seen",
                HttpMethod.POST,
                null,
                SuccessEntity.class,
                emailB64
        );
        if (result.getStatusCode() != HttpStatus.OK){
            System.out.println("Erorr: markSeen returned not OK!");
        }
        return result.getStatusCode() == HttpStatus.OK && result.getBody().isSuccess();
    }
}
