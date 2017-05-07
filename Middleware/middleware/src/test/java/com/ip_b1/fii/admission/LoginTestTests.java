package com.ip_b1.fii.admission;

import com.ip_b1.fii.admission.Controllers.LoginTest;
import com.ip_b1.fii.admission.DTO.LoginTestInEntity;
import com.ip_b1.fii.admission.DTO.LoginTestOutEntity;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class LoginTestTests {
    @Test
    public void testLoginTestInvalid(){
        LoginTest obj = new LoginTest();
        Assert.assertEquals(obj.testLogin(new LoginTestInEntity(null, null)).getStatusCode(),
                HttpStatus.UNAUTHORIZED);
        Assert.assertEquals(obj.testLogin(new LoginTestInEntity("admin@info.uaic.ro", null)).getStatusCode(),
                HttpStatus.UNAUTHORIZED);
        Assert.assertEquals(obj.testLogin(new LoginTestInEntity("admin@info.uaic.ro", "not_password")).getStatusCode(),
                HttpStatus.UNAUTHORIZED);
        Assert.assertEquals(obj.testLogin(new LoginTestInEntity("nonexistent@email.address", "password")).getStatusCode(),
                HttpStatus.UNAUTHORIZED);
    }

    @Test
    public void testLoginLive() {
        String username = "uaic_fii_b1_test@gmail.com";
        String password = "test!password"; //DO NOT CHANGE.
        if (!RegisterTest.createTestAccount(username, password)){
            System.err.println("Test register() failed, real login tests will not run.");
            Assert.fail("Test register() failed, real login tests will not run.");
        }

        ResponseEntity<LoginTestOutEntity> response;
        LoginTest obj = new LoginTest();

        response = obj.testLogin(new LoginTestInEntity(username, password));
        Assert.assertEquals(response.getStatusCode(), HttpStatus.OK);
        Assert.assertEquals(response.getBody().isSuccess(), true);
        Assert.assertEquals(response.getBody().getFailureReason(), null);
        Assert.assertNotEquals(response.getBody().getToken(), null);


        response = obj.testLogin(new LoginTestInEntity(username, password + "make_it_different"));
        Assert.assertEquals(response.getStatusCode(), HttpStatus.UNAUTHORIZED);
        Assert.assertEquals(response.getBody().isSuccess(), false);
        Assert.assertEquals(response.getBody().getToken(), null);
        Assert.assertNotEquals(response.getBody().getFailureReason(), null);

        response = obj.testLogin(new LoginTestInEntity(username + "make_it_different", password));
        Assert.assertEquals(response.getStatusCode(), HttpStatus.UNAUTHORIZED);
        Assert.assertEquals(response.getBody().isSuccess(), false);
        Assert.assertEquals(response.getBody().getToken(), null);
        Assert.assertNotEquals(response.getBody().getFailureReason(), null);
    }
}
