package com.ip_b1.fii.admission.Controllers;

import com.ip_b1.fii.admission.DTO.AuthEntity;
import com.ip_b1.fii.admission.DTO.NotificationsOutEntity;
import com.ip_b1.fii.admission.ModelStubs.AuthUtilsStub;
import com.ip_b1.fii.admission.ServerProperties;
import com.ip_b1.fii.admission.Utils.AuthUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.ResponseErrorHandler;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.URI;
import java.util.Base64;

@RestController
@RequestMapping("/controller/get_notifications")
public class GetNotifications {

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<NotificationsOutEntity> run(@RequestBody AuthEntity auth) {
        if (!AuthUtilsStub.claimsAuthenticated(auth)) {
            return new ResponseEntity<>(
                    new NotificationsOutEntity(null),
                    HttpStatus.UNAUTHORIZED
            );
        } else {
            try {
                //ServerProperties.modelUrl +

                String base64Encoded = new String(Base64.getEncoder().encode(auth.getEmail().getBytes()));

                String url = ServerProperties.modelUrl + "notificari/" + base64Encoded;

                RestTemplate template = new RestTemplate();

                template.setErrorHandler(new ResponseErrorHandler() {
                    @Override
                    public boolean hasError(ClientHttpResponse clientHttpResponse) throws IOException {
                        return false;
                    }

                    @Override
                    public void handleError(ClientHttpResponse clientHttpResponse) throws IOException {
                    }
                });

                ResponseEntity<NotificationsOutEntity> entity = template.getForEntity(
                        url,
                        NotificationsOutEntity.class
                );
                if (entity.getBody() == null)
                    return new ResponseEntity<>(
                            entity.getBody(),
                            HttpStatus.NOT_FOUND

                    );
                return new ResponseEntity<>(
                        entity.getBody(),
                        HttpStatus.OK
                );
            } catch(Exception e) {
                e.printStackTrace();
                return new ResponseEntity<>(
                        HttpStatus.INTERNAL_SERVER_ERROR
                );
            }
        }
    }

}
