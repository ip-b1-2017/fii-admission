package com.ip_b1.fii.admission;

import com.ip_b1.fii.admission.Controllers.LoginTest;
import com.ip_b1.fii.admission.DTO.LoginTestInEntity;
import com.ip_b1.fii.admission.DTO.LoginTestOutEntity;
import com.sun.org.apache.xpath.internal.SourceTree;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpStatusCodeException;

public class LoginTestTests {
    @Test
    public void testLoginTestInvalid() {
        LoginTest obj = new LoginTest();
        LoginTestInEntity loginTestInEntity = new LoginTestInEntity("sdvxc ", "Sgf");
        try {
            Assert.assertNotEquals(HttpStatus.OK,obj.testLogin(loginTestInEntity).getStatusCode());

        } catch (HttpStatusCodeException e) {
            Assert.assertEquals(HttpStatus.UNAUTHORIZED,e.getStatusCode());
            System.out.println(e.getStatusCode());
        }


        try {
            Assert.assertNotEquals(HttpStatus.OK,obj.testLogin(new LoginTestInEntity("nonexistent@email.address", "password")).getStatusCode());

        } catch (HttpStatusCodeException e) {
            Assert.assertEquals(HttpStatus.UNAUTHORIZED,e.getStatusCode());

        }
        try {
            Assert.assertNotEquals(HttpStatus.OK, obj.testLogin(new LoginTestInEntity("admin@info.uaic.ro", "not_password")).getStatusCode());

        } catch (HttpStatusCodeException e) {
            Assert.assertEquals(HttpStatus.UNAUTHORIZED,e.getStatusCode());

        }


    }

    @Test
    public void testLoginLive() {
        String username = "user@info.uaic.com";
        String password = "password"; //DO NOT CHANGE.
  /*      if (!RegisterTest.createTestAccount(username, password)){
            System.err.println("Test register() failed, real login tests will not run.");
            Assert.fail("Test register() failed, real login tests will not run.");
        }
*/
        ResponseEntity<LoginTestOutEntity> response;
        LoginTest obj = new LoginTest();

        response = obj.testLogin(new LoginTestInEntity(username, password));
        System.out.println(response.getBody().getFailureReason());
        Assert.assertEquals( HttpStatus.OK ,response.getStatusCode());
        Assert.assertEquals( true,response.getBody().isSuccess());
        Assert.assertEquals(response.getBody().getFailureReason(), null);
        Assert.assertNotEquals(response.getBody().getToken(), null);


    }
}
