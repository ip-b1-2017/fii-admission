package com.ip_b1.fii.admission.ModelStubs;

import com.ip_b1.fii.admission.DTO.DistributionEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Claudia Lucasi on 5/21/2017.
 */
@RestController
@RequestMapping("get_user_distribution")

public class GetUserDistributionStub {
    @RequestMapping(method = RequestMethod.GET)
     public ResponseEntity<DistributionEntity> getUserDist(){
        DistributionEntity dist = new DistributionEntity();
        dist.setEmail("email");
        dist.setClassroom("classroom");
        return new ResponseEntity<>(
                dist,
                HttpStatus.OK
        );
    }


}
