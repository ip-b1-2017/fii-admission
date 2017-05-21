package com.ip_b1.fii.admission;

import com.ip_b1.fii.admission.Controllers.AddResults;
import com.ip_b1.fii.admission.Controllers.ApplicationAccept;
import com.ip_b1.fii.admission.DTO.*;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class AddResultsTest {

    @Test
    public void regular_user_cant_use(){
        AuthEntity testEntity = new AuthEntity("alexd@info.uaic.ro", "some_valid_token");
        ResultInEntity result = new ResultInEntity();
        result.setAuth(testEntity);
        result.setNote(new Note());
        ResponseEntity<SuccessEntity> testResult;
        testResult = AddResults.setResult(result);
        Assert.assertEquals(HttpStatus.UNAUTHORIZED, testResult.getStatusCode());
    }

    @Test
    public void unique_CNP_inDB_works(){
        AuthEntity testEntity = new AuthEntity("admin@info.uaic.ro", "topkek");
        ResultInEntity result = new ResultInEntity();
        Note n = new Note();
        n.setCandidatCNP("1234567");
        n.setExamenId("100m");
        n.setValoare(7);
        result.setAuth(testEntity);
        result.setNote(n);
        ResponseEntity<SuccessEntity> testResult;
        testResult = AddResults.setResult(result);
        Assert.assertEquals(HttpStatus.OK, testResult.getStatusCode());
    }

    @Test
    public void invalid_CNP_not_work(){
        AuthEntity testEntity = new AuthEntity("admin@info.uaic.ro", "topkek");
        ResultInEntity result = new ResultInEntity();
        Note n = new Note();
        n.setCandidatCNP("12345678");
        n.setExamenId("100m");
        n.setValoare(7);
        result.setAuth(testEntity);
        result.setNote(n);
        ResponseEntity<SuccessEntity> testResult;
        testResult = AddResults.setResult(result);
        Assert.assertEquals(HttpStatus.NOT_MODIFIED, testResult.getStatusCode());
    }

    @Test
    public void unique_CNP_added_twice_not_work(){
        AuthEntity testEntity = new AuthEntity("admin@info.uaic.ro", "topkek");
        ResultInEntity result = new ResultInEntity();
        ResultInEntity result2 = new ResultInEntity();
        Note n = new Note();
        n.setCandidatCNP("1234567");
        n.setExamenId("100m");
        n.setValoare(7);
        result.setAuth(testEntity);
        result.setNote(n);
        result2.setAuth(testEntity);
        result2.setNote(n);
        ResponseEntity<SuccessEntity> testResult;
        testResult = AddResults.setResult(result);
        testResult = AddResults.setResult(result2);
        Assert.assertEquals(HttpStatus.NOT_MODIFIED, testResult.getStatusCode());
    }

}
