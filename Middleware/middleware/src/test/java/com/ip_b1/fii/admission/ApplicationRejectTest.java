package com.ip_b1.fii.admission;

import com.ip_b1.fii.admission.Controllers.ApplicationReject;
import com.ip_b1.fii.admission.DTO.AuthEntity;
import com.ip_b1.fii.admission.DTO.SuccessEntity;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ApplicationRejectTest {

    private ApplicationReject test;

    @BeforeEach
    private void setUp(){
        test = new ApplicationReject();
    }
    @AfterEach
    private void tearDown(){
        test = null;
    }

    @Test
    public void regular_user_cant_use(){
        AuthEntity testEntity = new AuthEntity("alexd@info.uaic.ro", "some_valid_token");
        ResponseEntity<SuccessEntity> testResult = test.reject(null, testEntity, "some_valid_cnp", "some_message");
        Assert.assertEquals(HttpStatus.UNAUTHORIZED, testResult.getStatusCode());
}

    @Test
    public void invalid_cnp_returns_not_found(){
        AuthEntity testEntity = new AuthEntity("admin@info.uaic.ro", "some_valid_token");
        ResponseEntity<SuccessEntity> testResult = test.reject(null, testEntity, "some_invalid_cnp", "some_message");
        Assert.assertEquals(HttpStatus.NOT_FOUND, testResult.getStatusCode());
    }

    @Test
    public void valid_cnp_returns_ok(){
        AuthEntity testEntity = new AuthEntity("admin@info.uaic.ro", "some_valid_token");
        ResponseEntity<SuccessEntity> testResult = test.reject(null, testEntity, "some_valid_cnp", "some_message");
        Assert.assertEquals(HttpStatus.OK, testResult.getStatusCode());
    }

}
