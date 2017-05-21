package com.ip_b1.fii.admission;

import com.ip_b1.fii.admission.Controllers.ApplicationAccept;
import com.ip_b1.fii.admission.Controllers.GetForm;
import com.ip_b1.fii.admission.DTO.AuthEntity;
import com.ip_b1.fii.admission.DTO.DistributionListEntity;
import com.ip_b1.fii.admission.DTO.FormOutEntity;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import javax.xml.ws.http.HTTPException;

public class GetFormTest {
    private GetForm test;

    @BeforeEach
    private void setUp(){
        test = new GetForm();
    }
    @AfterEach
    private void tearDown(){
        test = null;
    }

    @Test
    public void unauthorized_user() {

        test = new GetForm();
        AuthEntity testEntity;
        try {
            testEntity = new AuthEntity("admin@info.uaic.ro", "tkek");
            ResponseEntity<FormOutEntity> testResult = test.run(testEntity);
            Assert.assertNotEquals(HttpStatus.OK, testResult.getStatusCode());

        }
        catch(HTTPException e) {
            Assert.assertEquals(HttpStatus.UNAUTHORIZED, e.getStatusCode());
        }
    }

    @Test
    public void test_ok() {
        test = new GetForm();
        AuthEntity testEntity = new AuthEntity("admin@info.uaic.ro", "topkek");
        ResponseEntity<FormOutEntity> testResult = test.run(testEntity);
        Assert.assertEquals(HttpStatus.OK, testResult.getStatusCode());
    }
}
