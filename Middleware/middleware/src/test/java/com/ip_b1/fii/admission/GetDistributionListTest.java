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

public class GetDistributionListTest {

    private GetDistributionList test;

    @BeforeEach
    private void setUp() { test = new GetDistributionList(); }

    @AfterEach
    private void tearDown() { test = null; }

    @Test
    public void unauthorized_user() {
        AuthEntity testEntity = new AuthEntity("alexd@info.uaic.ro", "some_invalid_token");
        ResponseEntity<DistributionListEntity> testResult = test.run(testEntity);
        Assert.assertEquals(HttpStatus.UNAUTHORIZED, testResult.getStatusCode());
    }

    @Test
    public void test_ok() {
        AuthEntity testEntity = new AuthEntity("alexd@info.uaic.ro", "some_valid_token");
        ResponseEntity<DistributionListEntity> testResult = test.run(testEntity);
        Assert.assertTrue(HttpStatus.OK == testResult.getStatusCode() || HttpStatus.NOT_FOUND == testResult.getStatusCode());
    }
}
