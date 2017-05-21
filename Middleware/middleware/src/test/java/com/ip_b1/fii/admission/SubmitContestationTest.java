package com.ip_b1.fii.admission;


import com.ip_b1.fii.admission.Controllers.SubmitContestation;
import com.ip_b1.fii.admission.DTO.*;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import javax.xml.ws.http.HTTPException;

/**
 * Created by ddpv on 5/14/2017.
 */
public class SubmitContestationTest {
    private SubmitContestation test;
    private ContestationEntity formEntity;

    @BeforeEach
    private void setUp(){
        test = new SubmitContestation();

    }
    @AfterEach
    private void tearDown(){

        test = null;
    }

    @Test
    public void unauthorized_user() {

        test = new SubmitContestation();
        AuthEntity testEntity;
        try {
            testEntity = new AuthEntity("admin@info.uaic.ro", "tkek");
            ResponseEntity<SaveContestationOutEntity> testResult = test.testLogin("id",new ContestationEntity());
            Assert.assertNotEquals(HttpStatus.OK, testResult.getStatusCode());

        }
        catch(HTTPException e) {
            Assert.assertEquals(HttpStatus.UNAUTHORIZED, e.getStatusCode());
        }
    }

    @Test
    public void test_ok() {
        test = new SubmitContestation();
        AuthEntity testEntity = new AuthEntity("admin@info.uaic.ro", "topkek");
        ResponseEntity<SaveContestationOutEntity> testResult = test.testLogin("id",new ContestationEntity());
        Assert.assertEquals(HttpStatus.OK, testResult.getStatusCode());
    }
}
