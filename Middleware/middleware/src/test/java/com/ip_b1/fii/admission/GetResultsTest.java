package com.ip_b1.fii.admission;

import com.ip_b1.fii.admission.Controllers.GetResults;
import com.ip_b1.fii.admission.DTO.AuthEntity;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import javax.xml.ws.http.HTTPException;

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
        test = new GetResults();
        AuthEntity testEntity;
        try {
            testEntity = new AuthEntity("admin@info.uaic.ro", "tkek");
            ResponseEntity<String> testResult = test.getResults(testEntity);
            Assert.assertNotEquals(HttpStatus.OK, testResult.getStatusCode());

        }
        catch(HTTPException e) {
            Assert.assertEquals(HttpStatus.UNAUTHORIZED, e.getStatusCode());
        }
    }
    @Test
    public void test_ok() {
        test = new GetResults();
        AuthEntity testEntity = new AuthEntity("admin@info.uaic.ro", "topkek");
        ResponseEntity<String> testResult = test.getResults(testEntity);
        Assert.assertTrue(HttpStatus.OK == testResult.getStatusCode() || HttpStatus.NOT_FOUND == testResult.getStatusCode());
    }

}
