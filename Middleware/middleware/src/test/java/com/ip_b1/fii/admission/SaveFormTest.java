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

import javax.xml.ws.http.HTTPException;

/**
 * Created by ddpv on 5/14/2017.
 */
public class SaveFormTest {
    private SaveForm test;
    private FormEntity formEntity;

    @BeforeEach
    private void setUp(){
        test = new SaveForm();
    }
    @AfterEach
    private void tearDown() {
        test = null;
    }

    @Test
    public void unauthorized_user() {

        test = new SaveForm();
        AuthEntity testEntity;
        try {
            testEntity = new AuthEntity("admin@info.uaic.ro", "tkek");
            ResponseEntity<SaveFormOutEntity> testResult = test.testLogin(new FormEntity());
            Assert.assertNotEquals(HttpStatus.OK, testResult.getStatusCode());

        }
        catch(HTTPException e) {
            Assert.assertEquals(HttpStatus.UNAUTHORIZED, e.getStatusCode());
        }

    }

    @Test
    public void test_ok() {
        test = new SaveForm();
        AuthEntity testEntity = new AuthEntity("admin@info.uaic.ro", "topkek");
        ResponseEntity<SaveFormOutEntity> testResult = test.testLogin(new FormEntity());
        Assert.assertTrue(HttpStatus.OK == testResult.getStatusCode() || HttpStatus.NOT_FOUND == testResult.getStatusCode());
    }

}
