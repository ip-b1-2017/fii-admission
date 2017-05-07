package com.ip_b1.fii.admission.Controllers;

import com.ip_b1.fii.admission.DTO.AuthEntity;
import com.ip_b1.fii.admission.DTO.DistributionEntity;
import com.ip_b1.fii.admission.DTO.NotificationsOutEntity;
import com.ip_b1.fii.admission.ServerProperties;
import com.ip_b1.fii.admission.Utils.AuthUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/controller/get_distribution")
public class GetUserDistribution {

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<DistributionEntity> getUserDist(@RequestBody AuthEntity auth) {
        if (!AuthUtils.checkAuth(auth)) {
            return new ResponseEntity<>(
                    new DistributionEntity(),
                    HttpStatus.UNAUTHORIZED
            );
        } else {
            RestTemplate template = new RestTemplate();

            ResponseEntity<DistributionEntity> entity = template.getForEntity(
                    ServerProperties.modelUrl + "get_user_distribution",
                    DistributionEntity.class
            );
            if (entity.getBody() == null)
                return new ResponseEntity<>(
                        new DistributionEntity(),
                        HttpStatus.NOT_FOUND

                );
            return new ResponseEntity<>(
                    entity.getBody(),
                    HttpStatus.OK

            );
        }
    }

}
