package com.ip_b1.fii.admission.ModelStubs;

import com.ip_b1.fii.admission.DTO.ApplicationsEntity;
import com.ip_b1.fii.admission.DTO.AuthEntity;
import com.ip_b1.fii.admission.ServerProperties;
import com.ip_b1.fii.admission.Utils.AuthUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;


@RestController
    @RequestMapping("model/get_applications")
    public class GetApplicationsStub {


    @RequestMapping(method = RequestMethod.GET)
        public ResponseEntity<ApplicationsEntity> run() {
         ApplicationsEntity applicationsEntity = new ApplicationsEntity();
         ArrayList<String> l = new ArrayList<String>();
         l.add("info");
        applicationsEntity.setApplications(l);


                return new ResponseEntity<>(
                        applicationsEntity,
                        HttpStatus.OK
                );
        }


}
