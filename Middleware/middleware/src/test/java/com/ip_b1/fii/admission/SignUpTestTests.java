package com.ip_b1.fii.admission;

import com.ip_b1.fii.admission.Controllers.SaveForm;
import com.ip_b1.fii.admission.Controllers.SignUpTest;
import com.ip_b1.fii.admission.DTO.SignUpTestInEntity;
import com.ip_b1.fii.admission.DTO.SignUpTestOutEntity;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * Created by ddpv on 5/14/2017.
 */
public class SignUpTestTests {
    private SignUpTest test;
    private SignUpTestInEntity signUpTestInEntity;
    private SignUpTestOutEntity signUpTestOutEntity;

    @BeforeEach
    private void setUp(){
        test = new SignUpTest();
        signUpTestInEntity = new SignUpTestInEntity("email","pass");
        signUpTestOutEntity = new SignUpTestOutEntity(true,null);
    }
    @AfterEach
    private void tearDown(){
        signUpTestInEntity = null;
        signUpTestOutEntity = null;
        test = null;
    }
    @Test
    public void email_used(){
        ResponseEntity<SignUpTestOutEntity> testResult = test.testSignUp(new SignUpTestInEntity("usedemail","password"));
        Assert.assertEquals(testResult.getStatusCode(), HttpStatus.OK);
        Assert.assertEquals(testResult.getBody().isSuccess(), true);
        Assert.assertEquals(testResult.getBody().getFailureReason(), null);
    }

}
