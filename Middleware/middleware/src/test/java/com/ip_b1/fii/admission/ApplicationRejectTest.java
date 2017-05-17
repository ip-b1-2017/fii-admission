package com.ip_b1.fii.admission;

import com.ip_b1.fii.admission.Controllers.ApplicationReject;
import com.ip_b1.fii.admission.DTO.ApplicationReview;
import com.ip_b1.fii.admission.DTO.AuthEntity;
import com.ip_b1.fii.admission.DTO.SuccessEntity;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ApplicationRejectTest {

    @Test
    public void regular_user_cant_use(){
        AuthEntity testEntity = new AuthEntity("alexd@info.uaic.ro", "some_valid_token");
        ApplicationReview body = new ApplicationReview();
        body.setMessage("date incomplete");
        body.setCnp("123456");
        body.setUser(testEntity);
        ResponseEntity<SuccessEntity> testResult;
        testResult = ApplicationReject.reject(body);
        Assert.assertEquals(HttpStatus.UNAUTHORIZED, testResult.getStatusCode());
    }

    @Test
    public void invalid_cnp_returns_server_error(){
        AuthEntity testEntity = new AuthEntity("admin@info.uaic.ro", "topkek");
        ApplicationReview body = new ApplicationReview();
        body.setMessage("date incomplete");
        body.setCnp("1234567");
        body.setUser(testEntity);
        ResponseEntity<SuccessEntity> testResult = ApplicationReject.reject(body);
        Assert.assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, testResult.getStatusCode());
    }

    @Test
    public void valid_cnp_returns_ok(){
        AuthEntity testEntity = new AuthEntity("admin@info.uaic.ro", "topkek");
        ApplicationReview body = new ApplicationReview();
        body.setMessage("date incomplete");
        body.setCnp("123456");
        body.setUser(testEntity);
        ResponseEntity<SuccessEntity> testResult = ApplicationReject.reject(body);
        Assert.assertEquals(HttpStatus.OK, testResult.getStatusCode());
    }

}
