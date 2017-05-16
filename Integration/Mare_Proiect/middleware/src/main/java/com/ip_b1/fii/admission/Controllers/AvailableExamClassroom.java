package com.ip_b1.fii.admission.Controllers;

import com.ip_b1.fii.admission.DTO.AuthEntity;
import com.ip_b1.fii.admission.DTO.AvailableExamClassromEntity;
import com.ip_b1.fii.admission.Utils.AuthUtils;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/controller/available_classroom")
public class AvailableExamClassroom {

    @RequestMapping(value = "{id}", method = RequestMethod.POST)
    public ResponseEntity<AvailableExamClassromEntity> run(@PathVariable("id") Integer classroomID, @RequestBody AuthEntity auth) {

        if (AuthUtils.checkAuth(auth)) {
            return new ResponseEntity<>(new AvailableExamClassromEntity(),
                    HttpStatus.UNAUTHORIZED);
        }

        RestTemplate template = new RestTemplate();

        ResponseEntity<AvailableExamClassromEntity> entity = template.getForEntity(
                "/get_by_id_available_classroom/?classID={classID}", AvailableExamClassromEntity.class,
                classroomID);

        if (entity.getBody().getClass() == null) {
            return new ResponseEntity<>(new AvailableExamClassromEntity(),
                    HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(entity.getBody(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<List<AvailableExamClassromEntity>> getAllClassrooms(@RequestBody AuthEntity authEntity) {

        if (AuthUtils.checkAuth(authEntity)) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }

        RestTemplate template = new RestTemplate();

        ResponseEntity<List<AvailableExamClassromEntity>> entity = template.exchange("/get_all_available_classroom/",
                HttpMethod.POST, null, new ParameterizedTypeReference<List<AvailableExamClassromEntity>>() {
                });

        if (entity.getBody().getClass() == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(entity.getBody(), HttpStatus.OK);
    }
}
