package com.ip_b1.fii.admission.Controllers;

import com.ip_b1.fii.admission.DTO.ClassroomsEntity;
import com.ip_b1.fii.admission.DTO.ProfessorEntity;
import com.ip_b1.fii.admission.ServerProperties;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/controller/get_classrooms")
public class GetClassrooms {
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<List<ClassroomsEntity>> run() {

        RestTemplate template = new RestTemplate();

        ResponseEntity<List<ClassroomsEntity>> classroomResponse =
                template.exchange(ServerProperties.modelUrl + "/sali",
                        HttpMethod.GET, null, new ParameterizedTypeReference<List<ClassroomsEntity>>() {
                        });
        List<ClassroomsEntity> classrooms = classroomResponse.getBody();

        return new ResponseEntity<List<ClassroomsEntity>>(
                classrooms,
                HttpStatus.OK
        );
    }
}
