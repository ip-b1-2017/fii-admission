package com.ip_b1.fii.admission.Controllers;

import com.ip_b1.fii.admission.Controllers.DTO.AuthEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*@RestController
@RequestMapping("sesiune/")
public class GetSessionInfo {
}*/
@RestController
public class GetSessionInfo {

    @RequestMapping("/login_test")
    public void test(@RequestBody AuthEntity en){
        System.out.println(en.getUsername() + " " + en.getToken());
    }
}