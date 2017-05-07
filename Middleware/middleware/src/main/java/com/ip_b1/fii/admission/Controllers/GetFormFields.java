package com.ip_b1.fii.admission.Controllers;

import com.ip_b1.fii.admission.Controllers.DTO.AuthEntity;
import com.ip_b1.fii.admission.Controllers.DTO.FormOutEntity;
import com.ip_b1.fii.admission.Controllers.DTO.LoginTestOutEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/controller/get_form_fields")
public class GetFormFields {

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<FormOutEntity> testLogin(@RequestBody AuthEntity login) {
       // if (!checkUsernameAuth(login)) {

            //Edi face o verificare ms Edi
       // }


        System.out.println(login.getUsername());
        return new ResponseEntity<>(
                new FormOutEntity(null),
                HttpStatus.OK
        );
    }

}