package com.ip_b1.fii.admission;

import com.ip_b1.fii.admission.Controllers.SaveCandidate;
import com.ip_b1.fii.admission.DTO.AuthEntity;
import com.ip_b1.fii.admission.DTO.CandidateInEntity;
import com.ip_b1.fii.admission.DTO.SuccessEntity;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.springframework.http.HttpStatus.UNAUTHORIZED;

/**
 * Created by Claudia Lucasi on 5/13/2017.
 */
public class SaveCandidateTest {
    private SaveCandidate test;

    @BeforeEach
    private void setUp() { test = new SaveCandidate(); }

    @AfterEach
    private void tearDown() { test = null; }

    @Test
    public void unauthorized_user() {
        AuthEntity testEntity = new AuthEntity("email@info.uaic.ro", "invalid-token");
        CandidateInEntity testCandidate = new CandidateInEntity(testEntity, "invalid-cnp","invalid","invalid","invalid","invalid");
        ResponseEntity<SuccessEntity> testResult = test.saveCandidate(null,testCandidate);
        Assert.assertEquals(UNAUTHORIZED, testResult.getStatusCode());

    }

    @Test
    public void test_ok() {
        AuthEntity testEntity = new AuthEntity("claudia.lucasi@info.uaic.ro", "some_valid_token");
        CandidateInEntity testCandidate = new CandidateInEntity(testEntity, "some-cnp","firstname","lastname","adress","phone");
        ResponseEntity<SuccessEntity> testResult = test.saveCandidate(null,testCandidate);
        Assert.assertTrue(HttpStatus.OK == testResult.getStatusCode());
    }
}

