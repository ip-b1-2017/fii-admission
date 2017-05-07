package com.ip_b1.fii.admission.Controllers;

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

/**
 * Created by fenea on 5/7/2017.
 */
public class GetDistributionList {

    @RestController
    @RequestMapping("/controller/get_distribution")
    public class GetUserDistribution {

        @RequestMapping(method = RequestMethod.POST)
        public ResponseEntity<DistributionListEntity> getUserDist(@RequestBody AuthEntity auth) {
            if (!AuthUtils.checkAuth(auth)) {
                return new ResponseEntity<>(
                        new DistributionListEntity(),
                        HttpStatus.UNAUTHORIZED
                );
            } else {
                RestTemplate template = new RestTemplate();

                ResponseEntity<DistributionListEntity> entity = template.getForEntity(
                        ServerProperties.modelUrl + "get_distribution",
                        DistributionListEntity.class
                );
                if( entity.getBody()==null)
                    return new ResponseEntity<>(
                            new DistributionListEntity(),
                            HttpStatus.NOT_FOUND

                    );
                return new ResponseEntity<>(
                        entity.getBody(),
                        HttpStatus.OK

                );
            }
        }

    }

}
