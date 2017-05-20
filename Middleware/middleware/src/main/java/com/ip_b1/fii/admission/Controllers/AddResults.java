package com.ip_b1.fii.admission.Controllers;

import com.ip_b1.fii.admission.DTO.Note;
import com.ip_b1.fii.admission.DTO.ResultInEntity;
import com.ip_b1.fii.admission.DTO.SuccessEntity;
import com.ip_b1.fii.admission.ServerProperties;
import com.ip_b1.fii.admission.Utils.AuthUtils;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.ResponseErrorHandler;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

@RestController
@RequestMapping("/controller/set_result")
public class AddResults {

    @RequestMapping(method = RequestMethod.POST)
    public static ResponseEntity<SuccessEntity> setResult(@RequestBody ResultInEntity result) {
        if (!AuthUtils.checkAuthIsAdmin(result.getAuth())) {
            return new ResponseEntity<>(
                    new SuccessEntity(false),
                    HttpStatus.UNAUTHORIZED
            );
        } else {

            try {
                URI modelURI = new URI(ServerProperties.modelUrl + "/note");
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
                HttpEntity<Note> requestEntity = new HttpEntity<>(result.getNote());
                ResponseEntity<SuccessEntity> entity =
                        template.exchange(modelURI,
                                HttpMethod.PUT,
                                requestEntity,
                                SuccessEntity.class);

                if(entity.getStatusCode() == HttpStatus.NOT_MODIFIED)
                    return new ResponseEntity<>(new SuccessEntity(false),
                            HttpStatus.NOT_MODIFIED);
                else return new ResponseEntity<>(entity.getBody(),
                        HttpStatus.OK);
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
        }
        return new ResponseEntity<>(new SuccessEntity(false), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
