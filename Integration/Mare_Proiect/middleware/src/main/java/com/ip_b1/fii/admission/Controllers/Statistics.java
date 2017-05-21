package com.ip_b1.fii.admission.Controllers;

/**
 * Created by cosmin on 5/16/2017.
 */

import com.ip_b1.fii.admission.DTO.AdminStatisticsEntity;
import com.ip_b1.fii.admission.DTO.EmailEntity;
import com.ip_b1.fii.admission.DTO.StatisticiUserEntity;

import com.ip_b1.fii.admission.ServerProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.client.RestTemplate;

/**
 * Created by cosmin on 5/16/2017.
 */
@RestController
@RequestMapping(value = "/controller/statistics")
public class Statistics {
    @RequestMapping(value = "/get_user_statistics", method = RequestMethod.POST)
    public ResponseEntity<StatisticiUserEntity> getUserStatistics(@RequestBody EmailEntity email){
        StatisticiUserEntity statistici = new StatisticiUserEntity();
        statistici = getUStatistics(email);
        if(statistici==null){
            return new ResponseEntity<>(statistici, HttpStatus.INTERNAL_SERVER_ERROR);
        }else{
            return new ResponseEntity<>(statistici, HttpStatus.OK);
        }

    }

    @RequestMapping(value="/get_admin_statistics",method=RequestMethod.GET)
    public ResponseEntity<AdminStatisticsEntity> getAdminStatistics(){
            AdminStatisticsEntity statistics = new AdminStatisticsEntity();
            statistics = getAStatistics();
            if(statistics==null){
                return new ResponseEntity<AdminStatisticsEntity>(statistics,HttpStatus.INTERNAL_SERVER_ERROR);
            }else{
                return new ResponseEntity<AdminStatisticsEntity>(statistics,HttpStatus.OK);
            }
    }


    private StatisticiUserEntity getUStatistics(EmailEntity email){
        RestTemplate restTemplate = new RestTemplate();
        /*
        restTemplate.setErrorHandler(new ResponseErrorHandler() {
            @Override
            public boolean hasError(ClientHttpResponse clientHttpResponse) throws IOException {
                return false;
            }

            @Override
            public void handleError(ClientHttpResponse clientHttpResponse) throws IOException {

            }
        });*/
        ResponseEntity<StatisticiUserEntity> response = restTemplate.postForEntity(
                ServerProperties.modelUrl + "/statistics/get_user_statistics",
                email,
                StatisticiUserEntity.class
        );
        return response.getBody();
    }
    private AdminStatisticsEntity getAStatistics(){
        RestTemplate restTemplate = new RestTemplate();
        /*
        restTemplate.setErrorHandler(new ResponseErrorHandler() {
            @Override
            public boolean hasError(ClientHttpResponse clientHttpResponse) throws IOException {
                return false;
            }

            @Override
            public void handleError(ClientHttpResponse clientHttpResponse) throws IOException {

            }
        });*/
        ResponseEntity<AdminStatisticsEntity> response = restTemplate.getForEntity(
                ServerProperties.modelUrl + "/statistics/get_admin_statistics",
                AdminStatisticsEntity.class
        );
        return response.getBody();
    }
}