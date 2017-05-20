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
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
@RequestMapping("/controller/set_result")
public class AddResults {

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<SuccessEntity> setResult(@RequestBody ResultInEntity result) {
        if (!AuthUtils.checkAuthIsAdmin(result.getAuth())) {
            return new ResponseEntity<>(
                    new SuccessEntity(false),
                    HttpStatus.UNAUTHORIZED
            );
        } else {

            try {
                URI modelURI = new URI(ServerProperties.modelUrl + "/note");
                RestTemplate template = new RestTemplate();
                HttpEntity<Note> requestEntity = new HttpEntity<>(result.getNote());
                ResponseEntity<SuccessEntity> entity =
                        template.exchange(modelURI,
                                HttpMethod.PUT,
                                requestEntity,
                                SuccessEntity.class);

                if(entity.getBody().isSuccess())
                    return new ResponseEntity<>(
                        entity.getBody(),
                        HttpStatus.OK
                    );
                else return new ResponseEntity<>(entity.getBody(),
                        HttpStatus.NOT_MODIFIED);
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
        }
        return new ResponseEntity<>(new SuccessEntity(false), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
