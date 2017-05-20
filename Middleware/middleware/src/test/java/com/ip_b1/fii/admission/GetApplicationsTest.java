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

import javax.xml.ws.http.HTTPException;


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
            test = new GetApplications();
            AuthEntity testEntity;
            try {
                testEntity = new AuthEntity("invlid_email@info.uaic.ro", "invalid_token");
                ResponseEntity<ApplicationsEntity> testResult = test.run("user", testEntity);
                Assert.assertNotEquals(HttpStatus.OK, testResult.getStatusCode());
            }
                    catch(HTTPException e){
                        Assert.assertEquals(HttpStatus.UNAUTHORIZED, e.getStatusCode());
                }



        }
        @Test
        public void authorizedTest() {
            test = new GetApplications();
            AuthEntity testEntity = new AuthEntity("admin@info.uaic.ro", "topkek");
            ResponseEntity<ApplicationsEntity> testResult = test.run("admin", testEntity);
            Assert.assertEquals(HttpStatus.OK, testResult.getStatusCode());
        }




}
