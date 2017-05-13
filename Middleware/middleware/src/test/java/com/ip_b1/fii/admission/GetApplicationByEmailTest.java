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
        AuthEntity testEntity = new AuthEntity("user@info.uaic.ro", "token");
        ResponseEntity<FormOutEntity> testResult = test.run("user","random_email@uaic.info.ro", testEntity);
        Assert.assertEquals(HttpStatus.UNAUTHORIZED, testResult.getStatusCode());

    }
    @Test
    public void authorizedTest() {
        AuthEntity testEntity = new AuthEntity("admin@info.uaic.ro", "token");
        ResponseEntity<FormOutEntity> testResult = test.run("admin","valid_test_email@uaic.info.ro", testEntity);
        Assert.assertEquals(HttpStatus.OK, testResult.getStatusCode());
    }
    @Test
    public void invalidEmailTest() {
        AuthEntity testEntity = new AuthEntity("admin@info.uaic.ro", "token");
        ResponseEntity<FormOutEntity> testResult = test.run("admin","invalid_email@uaic.info.ro", testEntity);
        Assert.assertEquals(HttpStatus.NOT_FOUND, testResult.getStatusCode());
    }

}
