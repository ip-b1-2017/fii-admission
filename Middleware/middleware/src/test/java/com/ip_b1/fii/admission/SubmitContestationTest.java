package com.ip_b1.fii.admission;


import com.ip_b1.fii.admission.Controllers.SubmitContestation;
import com.ip_b1.fii.admission.DTO.*;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * Created by ddpv on 5/14/2017.
 */
public class SubmitContestationTest {
    private SubmitContestation test;
    private ContestationEntity formEntity;

    @BeforeEach
    private void setUp(){
        test = new SubmitContestation();
        formEntity = new ContestationEntity();
    }
    @AfterEach
    private void tearDown(){
        formEntity = null;
        test = null;
    }

    @Test
    public void unauthorized_user() {
        AuthEntity testEntity = new AuthEntity("alexd@info.uaic.ro", "some_invalid_token");
        formEntity.setAuth(testEntity);
        ResponseEntity<SaveContestationOutEntity> testResult = test.testLogin("id", formEntity);
        Assert.assertEquals(HttpStatus.UNAUTHORIZED, testResult.getStatusCode());
    }

    @Test
    public void authorized_user() {
        AuthEntity testEntity = new AuthEntity("alexd@info.uaic.ro", "valid_token");
        formEntity.setAuth(testEntity);
        ResponseEntity<SaveContestationOutEntity> testResult = test.testLogin("id", formEntity);
        Assert.assertEquals(HttpStatus.OK, testResult.getStatusCode());
    }
}
