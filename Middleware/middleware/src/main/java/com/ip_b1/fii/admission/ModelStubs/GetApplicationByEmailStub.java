package com.ip_b1.fii.admission.ModelStubs;

import com.ip_b1.fii.admission.DTO.FormFieldEntity;
import com.ip_b1.fii.admission.DTO.FormOutEntity;
import com.ip_b1.fii.admission.DTO.SetTokenEntity;
import com.ip_b1.fii.admission.DTO.SuccessEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Random;

@RestController
@RequestMapping("/get_application_by_email/{email}")
public class GetApplicationByEmailStub {

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<FormOutEntity> testLogin(@PathVariable String email) {
        FormOutEntity form = new FormOutEntity();
        System.out.println("get executed");
        System.out.println(email);
      if(email.equals("invalid_email")) {
          return new ResponseEntity<>(
                  form,
                  HttpStatus.OK
          );
      }
      else{
              ArrayList<FormFieldEntity> list = new ArrayList<>();
              list.add(new FormFieldEntity("fieldv", "valgfe"));
          list.add(new FormFieldEntity("Dfd","Sdgs"));
              form.setFields(list);
              return new ResponseEntity<>(
                      form,
                      HttpStatus.OK
              );
          }




    }

}




