package com.ip_b1.fii.admission;


import com.ip_b1.fii.admission.Controllers.GetForm;
import com.ip_b1.fii.admission.Controllers.SubmitForm;
import com.ip_b1.fii.admission.DTO.AuthEntity;
import com.ip_b1.fii.admission.DTO.FormEntity;
import com.ip_b1.fii.admission.DTO.FormOutEntity;
import com.ip_b1.fii.admission.DTO.SubmitFormOutEntity;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class SubmitFormTest {
    private SubmitForm test;
    private FormEntity formEntity;

    @BeforeEach
    private void setUp(){
        test = new SubmitForm();
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
        ResponseEntity<SubmitFormOutEntity> testResult = test.run(formEntity);
        Assert.assertEquals(HttpStatus.UNAUTHORIZED, testResult.getStatusCode());
    }

    @Test
    public void authorized_user() {
        AuthEntity testEntity = new AuthEntity("alexd@info.uaic.ro", "valid_token");
        formEntity.setAuth(testEntity);
        ResponseEntity<SubmitFormOutEntity> testResult = test.run(formEntity);
        Assert.assertEquals(HttpStatus.OK, testResult.getStatusCode());
    }

}
