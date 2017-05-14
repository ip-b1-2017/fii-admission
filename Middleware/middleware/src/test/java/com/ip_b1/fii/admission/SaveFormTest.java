package com.ip_b1.fii.admission;

import com.ip_b1.fii.admission.Controllers.SaveForm;
import com.ip_b1.fii.admission.DTO.AuthEntity;
import com.ip_b1.fii.admission.DTO.FormEntity;
import com.ip_b1.fii.admission.DTO.SaveFormOutEntity;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * Created by ddpv on 5/14/2017.
 */
public class SaveFormTest {
    private SaveForm test;
    private FormEntity formEntity;

    @BeforeEach
    private void setUp(){
        test = new SaveForm();
        formEntity = new FormEntity();
    }
    @AfterEach
    private void tearDown(){
        formEntity = null;
        test = null;
    }

    @Test
    public void unauthorized_user() {
        AuthEntity testEntity = new AuthEntity("alexd@info.uaic.ro", "some_invalid_token");
        formEntity.setAuth(testEntity);
        ResponseEntity<SaveFormOutEntity> testResult = test.testLogin(formEntity);
        Assert.assertEquals(HttpStatus.UNAUTHORIZED, testResult.getStatusCode());
    }

    @Test
    public void authorized_user() {
        AuthEntity testEntity = new AuthEntity("alexd@info.uaic.ro", "valid_token");
        formEntity.setAuth(testEntity);
        ResponseEntity<SaveFormOutEntity> testResult = test.testLogin(formEntity);
        Assert.assertEquals(HttpStatus.OK, testResult.getStatusCode());
    }

}
