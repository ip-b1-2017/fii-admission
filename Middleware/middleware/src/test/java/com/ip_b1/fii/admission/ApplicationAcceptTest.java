package com.ip_b1.fii.admission;

import com.ip_b1.fii.admission.Controllers.ApplicationAccept;
import com.ip_b1.fii.admission.DTO.AuthEntity;
import com.ip_b1.fii.admission.DTO.SuccessEntity;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ApplicationAcceptTest {

    private ApplicationAccept test;

    @BeforeEach
    private void setUp(){
        test = new ApplicationAccept();
    }
    @AfterEach
    private void tearDown(){
        test = null;
    }

    @Test
    public void regular_user_cant_use(){
        AuthEntity testEntity = new AuthEntity("alexd@info.uaic.ro", "some_valid_token");
        ResponseEntity<SuccessEntity> testResult = test.accept(null, testEntity, "some_valid_cnp");
        Assert.assertEquals(HttpStatus.UNAUTHORIZED, testResult.getStatusCode());
    }

    @Test
    public void invalid_cnp_returns_server_error(){
        AuthEntity testEntity = new AuthEntity("admin@info.uaic.ro", "some_valid_token");
        ResponseEntity<SuccessEntity> testResult = test.accept(null, testEntity, "some_invalid_cnp");
        Assert.assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, testResult.getStatusCode());
    }

    @Test
    public void valid_cnp_returns_ok(){
        AuthEntity testEntity = new AuthEntity("admin@info.uaic.ro", "some_valid_token");
        ResponseEntity<SuccessEntity> testResult = test.accept(null, testEntity, "some_valid_cnp");
        Assert.assertEquals(HttpStatus.OK, testResult.getStatusCode());
    }
}
