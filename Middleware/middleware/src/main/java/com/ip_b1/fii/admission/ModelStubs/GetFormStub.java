package com.ip_b1.fii.admission.ModelStubs;

import com.ip_b1.fii.admission.DTO.FormFieldEntity;
import com.ip_b1.fii.admission.DTO.FormOutEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

/**
 * Created by fenea on 5/21/2017.
 */






    @RestController
    @RequestMapping("/get_form/{email}")
    public class GetFormStub {

        @RequestMapping(method = RequestMethod.GET)
        public ResponseEntity<FormOutEntity> testLogin(@PathVariable String email) {


            String emailDecoded = new String(Base64.getDecoder().decode(email.getBytes()));
            System.out.println(emailDecoded);
            FormOutEntity form = new FormOutEntity();
            FormFieldEntity field = new FormFieldEntity();
            field.setField("field");
            field.setValue("value");
            List<FormFieldEntity> list = new ArrayList<>();
            list.add(field);
            form.setFields(list);

                return new ResponseEntity<>(
                        form,
                        HttpStatus.OK
                );
        }

}
