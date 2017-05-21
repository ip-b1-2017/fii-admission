package com.ip_b1.fii.admission;

import com.ip_b1.fii.admission.Controllers.GetUserDistribution;
import com.ip_b1.fii.admission.DTO.AuthEntity;
import com.ip_b1.fii.admission.DTO.DistributionEntity;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import javax.xml.ws.http.HTTPException;

import static org.springframework.http.HttpStatus.UNAUTHORIZED;

/**
 * Created by Claudia Lucasi on 5/13/2017.
 */
public class GetUserDistributionTest {
    private GetUserDistribution test;

    @BeforeEach
    private void setUp() { test = new GetUserDistribution(); }

    @AfterEach
    private void tearDown() { test = null; }

    @Test
    public void unauthorized_user() {
        test = new GetUserDistribution();
        AuthEntity testEntity;
        try {
            testEntity = new AuthEntity("admin@info.uaic.ro", "tkek");
            ResponseEntity<DistributionEntity> testResults = test.getUserDist(testEntity);
            Assert.assertEquals(UNAUTHORIZED, testResults.getStatusCode());
        }
        catch(HTTPException e) {
            Assert.assertEquals (HttpStatus.UNAUTHORIZED, e.getStatusCode());
        }

    }
    @Test
    public void test_ok() {
        test = new GetUserDistribution();
        AuthEntity testEntity = new AuthEntity("admin@info.uaic.ro", "topkek");
        ResponseEntity<DistributionEntity> testResults = test.getUserDist( testEntity);
        Assert.assertTrue(HttpStatus.OK == testResults.getStatusCode() || HttpStatus.NOT_FOUND == testResults.getStatusCode());
    }
}
