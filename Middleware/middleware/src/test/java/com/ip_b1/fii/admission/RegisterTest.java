package com.ip_b1.fii.admission;

import com.ip_b1.fii.admission.Controllers.SignUpTest;
import com.ip_b1.fii.admission.DTO.SignUpTestInEntity;
import com.ip_b1.fii.admission.DTO.SignUpTestOutEntity;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Random;

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

    @Test
    public void testRegisterTestInvalid(){
        SignUpTest obj = new SignUpTest();

        ResponseEntity<SignUpTestOutEntity> result;

        result = obj.testSignUp(new SignUpTestInEntity(null, null));
        Assert.assertNotEquals(result.getStatusCode(), HttpStatus.OK);
        Assert.assertEquals(result.getBody().isSuccess(), false);
        Assert.assertNotEquals(result.getBody().getFailureReason(), null);

        result = obj.testSignUp(new SignUpTestInEntity("some@email.address", null));
        Assert.assertNotEquals(result.getStatusCode(), HttpStatus.OK);
        Assert.assertEquals(result.getBody().isSuccess(), false);
        Assert.assertNotEquals(result.getBody().getFailureReason(), null);

        result = obj.testSignUp(new SignUpTestInEntity(null, "some_password"));
        Assert.assertNotEquals(result.getStatusCode(), HttpStatus.OK);
        Assert.assertEquals(result.getBody().isSuccess(), false);
        Assert.assertNotEquals(result.getBody().getFailureReason(), null);
    }

    @Test
    public void testRegisterLive(){
        SignUpTest obj = new SignUpTest();
        Random random = new Random();

        ResponseEntity<SignUpTestOutEntity> result;
        String email = "new_email_address_" + String.valueOf(random.nextInt()) + "@app_tests.com";
        String password = "idk_password_1234";

        result = obj.testSignUp(new SignUpTestInEntity(email, password));
        Assert.assertEquals(result.getStatusCode(), HttpStatus.CREATED);
        Assert.assertEquals(result.getBody().isSuccess(), true);
        Assert.assertEquals(result.getBody().getFailureReason(), null);

        // Test with same username & password
        result = obj.testSignUp(new SignUpTestInEntity(email, password));
        Assert.assertEquals(result.getStatusCode(), HttpStatus.BAD_REQUEST);
        Assert.assertEquals(result.getBody().isSuccess(), false);
        Assert.assertNotEquals(result.getBody().getFailureReason(), null);

        // Test with same username, different password
        result = obj.testSignUp(new SignUpTestInEntity(email, password + "but this is different"));
        Assert.assertEquals(result.getStatusCode(), HttpStatus.BAD_REQUEST);
        Assert.assertEquals(result.getBody().isSuccess(), false);
        Assert.assertNotEquals(result.getBody().getFailureReason(), null);

        // Test with another username, same password
        email = "new_email_address_" + String.valueOf(random.nextInt()) + "@app_tests.com";
        result = obj.testSignUp(new SignUpTestInEntity(email, password));
        Assert.assertEquals(result.getStatusCode(), HttpStatus.CREATED);
        Assert.assertEquals(result.getBody().isSuccess(), true);
        Assert.assertEquals(result.getBody().getFailureReason(), null);

        //TODO: maybe delete these in the future?
    }
}
