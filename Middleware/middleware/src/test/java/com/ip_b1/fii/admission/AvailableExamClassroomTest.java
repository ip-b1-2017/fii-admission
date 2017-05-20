package com.ip_b1.fii.admission;

import com.ip_b1.fii.admission.Controllers.AvailableExamClassroom;
import com.ip_b1.fii.admission.DTO.AuthEntity;
import com.ip_b1.fii.admission.DTO.AvailableExamClassromEntity;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpStatusCodeException;

public class AvailableExamClassroomTest {

    private AvailableExamClassroom test;
    private int validClassroomId ;
    private int invalidClassroomId ;
    @BeforeEach
    private void setUp(){
        test = new AvailableExamClassroom();
        validClassroomId = 1;
        invalidClassroomId =-1;
    }

    @AfterEach
    private void tearDown(){
        test = null;
    }
    @Test
    public void unauthorizedTest() {
        ResponseEntity<AvailableExamClassromEntity> testResult;
        AuthEntity testEntity = new AuthEntity("email@info.uaic.ro", "invalid-token");
        try {

            testResult = test.run(validClassroomId, testEntity);
        } catch(HttpStatusCodeException e) {
            Assert.assertEquals(HttpStatus.UNAUTHORIZED, e.getStatusCode());
        }

    }
    @Test
    public void authorizedTest() {
        AuthEntity testEntity = new AuthEntity("email@info.uaic.ro", "token");

        ResponseEntity<AvailableExamClassromEntity> testResult = test.run(validClassroomId,testEntity);
        Assert.assertEquals(HttpStatus.OK, testResult.getStatusCode());

    }
    @Test
    public void invalidClassroom() {
        AuthEntity testEntity = new AuthEntity("email@info.uaic.ro", "token");

        ResponseEntity<AvailableExamClassromEntity> testResult = test.run(invalidClassroomId,testEntity);
        Assert.assertEquals(HttpStatus.NOT_FOUND, testResult.getStatusCode());

    }

}
