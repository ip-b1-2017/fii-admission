package com.ip_b1.fii.admission;

import com.ip_b1.fii.admission.Controllers.GetNotifications;
import com.ip_b1.fii.admission.DTO.AuthEntity;
import com.ip_b1.fii.admission.DTO.DistributionListEntity;
import com.ip_b1.fii.admission.DTO.NotificationsOutEntity;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class GetNotificationsTest {
    private GetNotifications test;

    @BeforeEach
    private void setUp() { test = new GetNotifications(); }

    @AfterEach
    private void tearDown() { test = null; }

    @Test
    public void unauthorized_user() {
        AuthEntity testEntity = new AuthEntity("alexd@info.uaic.ro", "some_invalid_token");
        ResponseEntity<NotificationsOutEntity> testResult = test.run(null, testEntity);
        Assert.assertEquals(HttpStatus.UNAUTHORIZED, testResult.getStatusCode());
    }

    @Test
    public void test_ok() {
        AuthEntity testEntity = new AuthEntity("alexd@info.uaic.ro", "some_valid_token");
        ResponseEntity<NotificationsOutEntity> testResult = test.run(null, testEntity);
        Assert.assertTrue(HttpStatus.OK == testResult.getStatusCode() || HttpStatus.NOT_FOUND == testResult.getStatusCode());
    }
}
