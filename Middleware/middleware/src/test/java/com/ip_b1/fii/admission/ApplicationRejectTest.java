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

    }

    @Test
    public void invalid_cnp_returns_not_found(){

    }

    @Test
    public void valid_cnp_returns_ok(){

    }

}
