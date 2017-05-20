package com.ip_b1.fii.admission;

import com.ip_b1.fii.admission.Controllers.GetDistributionList;
import com.ip_b1.fii.admission.DTO.AuthEntity;
import com.ip_b1.fii.admission.DTO.DistributionListEntity;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpStatusCodeException;

public class GetDistributionListTest {

    private GetDistributionList test;

    @BeforeEach
    private void setUp() { test = new GetDistributionList(); }

    @AfterEach
    private void tearDown() { test = null; }

    @Test
    public void unauthorized_user() {
        test = new GetDistributionList();
        AuthEntity testEntity;
        try {
            testEntity = new AuthEntity("alexd@info.uaic.ro", "some_invalid_token");
            ResponseEntity<DistributionListEntity> testResult = test.run(testEntity);
            Assert.assertNotEquals(HttpStatus.OK ,testResult.getStatusCode());
        }catch(HttpStatusCodeException e) {
            Assert.assertEquals(HttpStatus.UNAUTHORIZED, e.getStatusCode());
        }
    }

    @Test
    public void test_ok() {
        test = new GetDistributionList();
        AuthEntity testEntity = new AuthEntity("admin@info.uaic.ro", "topkek");
        ResponseEntity<DistributionListEntity> testResult = test.run(testEntity);
        Assert.assertTrue(HttpStatus.OK == testResult.getStatusCode());
    }
 /*   @Test
    public void notFound() {
        test = new GetDistributionList();
        AuthEntity testEntity;
        try {
            testEntity = new AuthEntity("admin@info.uaic.ro", "topkek");
            ResponseEntity<DistributionListEntity> testResult = test.run(testEntity);
            Assert.assertNotEquals(HttpStatus.OK ,testResult.getStatusCode());
        }
        catch(HttpStatusCodeException e) {
            Assert.assertTrue(HttpStatus.NOT_FOUND == e.getStatusCode());
        }
    }
    */
}
