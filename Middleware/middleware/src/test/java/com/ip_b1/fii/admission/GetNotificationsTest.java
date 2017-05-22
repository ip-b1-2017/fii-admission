package com.ip_b1.fii.admission;

import com.ip_b1.fii.admission.Controllers.GetNotifications;
import com.ip_b1.fii.admission.DTO.AuthEntity;
import com.ip_b1.fii.admission.DTO.NotificationsOutEntity;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class GetNotificationsTest {
    private GetNotifications test;

    @AfterEach
    private void tearDown() { test = null; }

    @Test
    public void unauthorized_user_tries_to_get() {
        test = new GetNotifications();
        AuthEntity testEntity = new AuthEntity("alexd(at)info.uaic.ro", null);
        ResponseEntity<NotificationsOutEntity> testResult = test.run(testEntity);
        Assert.assertEquals(HttpStatus.UNAUTHORIZED, testResult.getStatusCode());
    }

    @Test
    public void authorized_but_no_notifications() {
        test = new GetNotifications();
        AuthEntity testEntity = new AuthEntity("alexd@info.uaic.ro", "some_valid_token");
        ResponseEntity<NotificationsOutEntity> testResult = test.run(testEntity);
        Assert.assertEquals(HttpStatus.NOT_FOUND, testResult.getStatusCode());
    }

    @Test
    public void authorized_and_has_notifications() {
        test = new GetNotifications();
        AuthEntity testEntity = new AuthEntity("alexxx@info.uaic.ro", "some_valid_token");
        ResponseEntity<NotificationsOutEntity> testResult = test.run(testEntity);
        Assert.assertEquals(HttpStatus.OK, testResult.getStatusCode());
    }
}
