package com.ip_b1.fii.admission.ModelStubs;


import com.ip_b1.fii.admission.DTO.AuthEntity;
import com.ip_b1.fii.admission.DTO.DistributionEntity;
import com.ip_b1.fii.admission.DTO.DistributionListEntity;
import com.ip_b1.fii.admission.ServerProperties;
import com.ip_b1.fii.admission.Utils.AuthUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;


@RestController
    @RequestMapping("get_distribution")
    public class GetDistributionListStub {

        @RequestMapping(method = RequestMethod.GET)
        public ResponseEntity<DistributionListEntity> run() {
            DistributionListEntity dist = new DistributionListEntity();
            ArrayList<DistributionEntity> list = new ArrayList<>();
            DistributionEntity entity =  new DistributionEntity();
            entity.setEmail("email");
            entity.setClassroom("classroom");
            list.add(entity);
            dist.setDistributionList(list);

                return new ResponseEntity<>(
                        dist,
                        HttpStatus.OK

                );
           }


}
