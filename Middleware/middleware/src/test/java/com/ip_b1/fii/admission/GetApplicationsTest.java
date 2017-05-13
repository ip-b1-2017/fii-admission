package com.ip_b1.fii.admission;

import com.ip_b1.fii.admission.Controllers.GetApplicationByEmail;
import com.ip_b1.fii.admission.Controllers.GetApplications;
import com.ip_b1.fii.admission.DTO.ApplicationsEntity;
import com.ip_b1.fii.admission.DTO.AuthEntity;
import com.ip_b1.fii.admission.DTO.FormOutEntity;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;




    public class GetApplicationsTest {

        private GetApplications test;

        @BeforeEach
        private void setUp(){
            test = new GetApplications();
        }


        @AfterEach
        private void tearDown(){
            test = null;
        }
        @Test
        public void unauthorizedTest() {
            AuthEntity testEntity = new AuthEntity("invlid_email@info.uaic.ro", "invalid_token");
            ResponseEntity<ApplicationsEntity> testResult = test.run("user", testEntity);
            Assert.assertEquals(HttpStatus.UNAUTHORIZED, testResult.getStatusCode());

        }
        @Test
        public void authorizedTest() {
            AuthEntity testEntity = new AuthEntity("user@info.uaic.ro", "token");
            ResponseEntity<ApplicationsEntity> testResult = test.run("user", testEntity);
            Assert.assertEquals(HttpStatus.OK, testResult.getStatusCode());
        }



}
