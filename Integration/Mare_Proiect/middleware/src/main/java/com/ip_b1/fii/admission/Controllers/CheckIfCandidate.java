package com.ip_b1.fii.admission.Controllers;

import com.ip_b1.fii.admission.DTO.*;
import com.ip_b1.fii.admission.Utils.UserUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/controller/check_if_candidate")
public class CheckIfCandidate {

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<SuccessEntity> checkIfCandidate(@RequestBody AuthEntity auth) {
        String cnp = UserUtils.getCandidateCnp(auth.getUsername());
        System.out.println(cnp);
        SuccessEntity successEntity = new SuccessEntity();
        if (cnp == null) {
            successEntity.setSuccess(false);
            return new ResponseEntity<>(successEntity,
                    HttpStatus.NOT_FOUND
            );
        }
        else{
            successEntity.setSuccess(true);
            return new ResponseEntity<>(successEntity,
                    HttpStatus.OK
            );
        }


    }
}
