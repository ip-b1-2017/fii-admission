package com.ip_b1.fii.admission.Controllers;

import com.ip_b1.fii.admission.DTO.*;
import com.ip_b1.fii.admission.ServerProperties;
import com.ip_b1.fii.admission.Utils.AuthUtils;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/controller/add_classroom")
public class AddClassroom {

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<ClassroomsEntity> setResult(@RequestBody ClassroomsEntity classroom) {
        ClassroomsEntity classroomToAdd = new ClassroomsEntity();
        classroomToAdd.setId(classroom.getId());
        classroomToAdd.setLocatie(classroom.getLocatie());
        classroomToAdd.setNrLocuri(classroom.getNrLocuri());

        RestTemplate template = new RestTemplate();

        template.put(
                ServerProperties.modelUrl + "/sali",
                classroomToAdd);


        return new ResponseEntity<ClassroomsEntity>(
                //response,
                HttpStatus.OK
        );
    }
}