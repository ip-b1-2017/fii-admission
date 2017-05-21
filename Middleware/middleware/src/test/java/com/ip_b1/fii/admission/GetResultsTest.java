package com.ip_b1.fii.admission;

import com.ip_b1.fii.admission.Controllers.GetResults;
import com.ip_b1.fii.admission.DTO.AuthEntity;
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
public class GetResultsTest {
    private GetResults test;

    @BeforeEach
    private void setUp() { test = new GetResults(); }

    @AfterEach
    private void tearDown() { test = null; }

    @Test
    public void unauthorized_user() {
        AuthEntity testEntity = new AuthEntity("email@info.uaic.ro", "invalid-token");

        ResponseEntity<String> testResult = test.getResults(testEntity);
        Assert.assertEquals(UNAUTHORIZED, testResult.getStatusCode());

    }
    @Test
    public void test_ok() {
        AuthEntity testEntity = new AuthEntity("claudia.lucasi@info.uaic.ro", "some_valid_token");
        ResponseEntity<String> testResult = test.getResults( testEntity);
        Assert.assertTrue(HttpStatus.OK == testResult.getStatusCode() || HttpStatus.NOT_FOUND == testResult.getStatusCode());
    }

}
