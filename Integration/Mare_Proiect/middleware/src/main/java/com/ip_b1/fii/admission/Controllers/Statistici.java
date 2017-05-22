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
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.client.ResponseErrorHandler;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

/**
 * Created by cosmin on 5/16/2017.
 */
@RestController
@RequestMapping(value = "/controller/statistici")
public class Statistici {
    @RequestMapping(value = "/get_statistici_user", method = RequestMethod.POST)
    public ResponseEntity<StatisticiUserEntity> getStatistici(@RequestBody EmailEntity email){
        StatisticiUserEntity statistici = new StatisticiUserEntity();
        statistici = getStatisticiUser(email);
        if(statistici==null){
            return new ResponseEntity<>(statistici, HttpStatus.INTERNAL_SERVER_ERROR);
        }else{
            return new ResponseEntity<>(statistici, HttpStatus.OK);
        }

    }

    @RequestMapping(value = "/get_statistics_admin", method = RequestMethod.GET)
    public ResponseEntity<AdminStatisticsEntity> getStatisticiAdmin(){
        AdminStatisticsEntity statistici;
        statistici = getStatisticsAdmin();

        if(statistici==null){
            return new ResponseEntity<>(statistici, HttpStatus.INTERNAL_SERVER_ERROR);
        }else{
            return new ResponseEntity<>(statistici, HttpStatus.OK);
        }

    }

    private AdminStatisticsEntity getStatisticsAdmin(){
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
                ServerProperties.modelUrl + "/statistici/get_statistics_admin",
                AdminStatisticsEntity.class
        );

        return response.getBody();
    }



    private StatisticiUserEntity getStatisticiUser(EmailEntity email){
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
                ServerProperties.modelUrl + "/statistici/get_statistici_user",
                email,
                StatisticiUserEntity.class
        );
        return response.getBody();
    }
}