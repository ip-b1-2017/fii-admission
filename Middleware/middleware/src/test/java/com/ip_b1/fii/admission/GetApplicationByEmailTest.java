package com.ip_b1.fii.admission;


import com.ip_b1.fii.admission.Controllers.ApplicationAccept;
import com.ip_b1.fii.admission.Controllers.GetApplicationByEmail;
import com.ip_b1.fii.admission.Controllers.LoginTest;
import com.ip_b1.fii.admission.DTO.AuthEntity;
import com.ip_b1.fii.admission.DTO.FormOutEntity;
import com.ip_b1.fii.admission.DTO.LoginTestOutEntity;
import com.ip_b1.fii.admission.DTO.SuccessEntity;
import com.ip_b1.fii.admission.Utils.AuthUtils;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpStatusCodeException;

import javax.xml.ws.http.HTTPException;

public class GetApplicationByEmailTest {

    private GetApplicationByEmail test;

    @BeforeEach
    private void setUp(){
        test = new GetApplicationByEmail();
    }


    @AfterEach
    private void tearDown(){
        test = null;
    }
    @Test

    public void unauthorizedTest() {
        AuthEntity testEntity;
        ResponseEntity<FormOutEntity> testResult;
       test = new GetApplicationByEmail();
        try {

            testEntity = new AuthEntity("admin@info.uaic.ro", "tokek");

            testResult = test.run("random_email@uaic.info.ro", testEntity);
            Assert.assertNotEquals(HttpStatus.OK, testResult.getStatusCode());
        }
    catch (HttpStatusCodeException e){
            Assert.assertEquals(HttpStatus.UNAUTHORIZED, e.getStatusCode());
        }

    }
    @Test
    public void authorizedTest() {
        test = new GetApplicationByEmail();
        AuthEntity testEntity = new AuthEntity("admin@info.uaic.ro", "topkek");
        ResponseEntity<FormOutEntity> testResult = test.run("valid_test_email", testEntity);
        Assert.assertEquals(HttpStatus.OK, testResult.getStatusCode());
    }
    @Test
    public void invalidEmailTest() {
        test = new GetApplicationByEmail();
        AuthEntity testEntity = new AuthEntity("admin@info.uaic.ro", "topkek");
        ResponseEntity<FormOutEntity> testResult ;
        try {
            testResult = test.run("invalid_email", testEntity);
            Assert.assertNotEquals(HttpStatus.OK, testResult.getStatusCode());
        }catch(HttpStatusCodeException e) {
            Assert.assertEquals(HttpStatus.NOT_FOUND, e.getStatusCode());
        }
    }

}
