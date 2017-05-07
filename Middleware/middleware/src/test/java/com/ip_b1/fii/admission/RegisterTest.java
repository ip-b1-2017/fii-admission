package com.ip_b1.fii.admission;

import com.ip_b1.fii.admission.Controllers.SignUpTest;
import com.ip_b1.fii.admission.DTO.SignUpTestInEntity;
import com.ip_b1.fii.admission.DTO.SignUpTestOutEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class RegisterTest {
    public static boolean createTestAccount(String email, String password){
        SignUpTest obj = new SignUpTest();
        ResponseEntity<SignUpTestOutEntity> result = obj.testSignUp(new SignUpTestInEntity(email, password));
        if (result.getStatusCode() == HttpStatus.CREATED) {
            return true;
        }
        //noinspection RedundantIfStatement
        if (result.getBody().getFailureReason().equals("Email Used")){
            //Well let's hope the password is OK...
            return true;
        }
        else{
            return false;
        }
    }
}
