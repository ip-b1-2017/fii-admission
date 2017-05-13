package com.ip_b1.fii.admission.Controllers;

import com.ip_b1.fii.admission.DTO.LoginTestInEntity;
import com.ip_b1.fii.admission.DTO.LoginTestOutEntity;
import com.ip_b1.fii.admission.DTO.SetTokenEntity;
import com.ip_b1.fii.admission.DTO.SuccessEntity;
import com.ip_b1.fii.admission.ServerProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Random;

@RestController
@RequestMapping("/controller/login_test")
public class LoginTest {

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<LoginTestOutEntity>testLogin(@RequestBody LoginTestInEntity login) {
        if (!check(login)) {
            return new ResponseEntity<>(
                    new LoginTestOutEntity(false, null, "Failed login"),
                    HttpStatus.UNAUTHORIZED
            );
        }

        String token = authenticateUser(login.getUsername());
        if (token == null) {
            return new ResponseEntity<>(
                    new LoginTestOutEntity(false, null, "Couldn't set token"),
                    HttpStatus.INTERNAL_SERVER_ERROR
            );
        }
        return new ResponseEntity<>(
                new LoginTestOutEntity(true, token, null),
                HttpStatus.OK
        );
    }

    private String authenticateUser(String username) {
        RestTemplate restTemplate = new RestTemplate();
        String newToken = generateToken();

        ResponseEntity<SuccessEntity> response = restTemplate.postForEntity(
                ServerProperties.modelUrl + "/users/set_token",
                new SetTokenEntity(username, newToken),
                SuccessEntity.class
        );

        if (response.getStatusCode() == HttpStatus.CREATED && response.getBody().isSuccess()) {
            return newToken;
        } else {
            return null;
        }

    }

    private String generateToken() {
        String charset = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        int length = 16;
        StringBuilder result = new StringBuilder(length);
        Random random = new Random();
        for (int i = 0; i < length; i++){
            result.append(charset.charAt(random.nextInt(charset.length())));
        }
        return result.toString();
    }

    private static boolean check(LoginTestInEntity login) {
        RestTemplate restTemplate = new RestTemplate();
        SuccessEntity entity = restTemplate.postForObject(
                ServerProperties.modelUrl + "/users/check_password",
                login,
                SuccessEntity.class);
        return entity.isSuccess();
    }

}
