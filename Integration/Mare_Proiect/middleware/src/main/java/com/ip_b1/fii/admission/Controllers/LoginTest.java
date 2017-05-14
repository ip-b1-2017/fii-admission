package com.ip_b1.fii.admission.Controllers;

import com.ip_b1.fii.admission.DTO.LoginTestInEntity;
import com.ip_b1.fii.admission.DTO.LoginTestOutEntity;
import com.ip_b1.fii.admission.DTO.SetTokenEntity;
import com.ip_b1.fii.admission.DTO.SuccessEntity;
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
import java.util.Map;
import java.util.Random;

@RestController
@RequestMapping(value="/controller/login_test")
public class LoginTest {

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<LoginTestOutEntity>testLogin(@RequestBody LoginTestInEntity login) {
        LoginTestOutEntity entity = new LoginTestOutEntity();

        if (!check(login)) {
            entity.setSuccess(false);
            entity.setFailureReason("Failed login");
            entity.setToken(null);
            return new ResponseEntity<>(
                    entity,
                    HttpStatus.NOT_FOUND
            );
        }

        String token = authenticateUser(login.getUsername());
        if (token == null) {
            entity.setSuccess(false);
            entity.setFailureReason("Couldn't set token");
            entity.setToken(null);
            return new ResponseEntity<>(
                    entity,
                    HttpStatus.INTERNAL_SERVER_ERROR
            );
        }
        entity.setSuccess(true);
        entity.setFailureReason(null);
        entity.setToken(token);
        return new ResponseEntity<>(
                entity,
                HttpStatus.OK
        );

    }

    private String authenticateUser(String username) {
        RestTemplate restTemplate = new RestTemplate();
        String newToken = generateToken();

        restTemplate.setErrorHandler(new ResponseErrorHandler() {
            @Override
            public boolean hasError(ClientHttpResponse clientHttpResponse) throws IOException {
                return false;
            }

            @Override
            public void handleError(ClientHttpResponse clientHttpResponse) throws IOException {

            }
        });
        SetTokenEntity token = new SetTokenEntity();
        token.setToken(newToken);
        token.setEmail(username);
        System.out.println(newToken);
        System.out.println(token.getEmail());

        ResponseEntity<SuccessEntity> response = restTemplate.postForEntity(
                ServerProperties.modelUrl + "/users/set_token",
                token,
                SuccessEntity.class
        );

        System.out.println(response.getBody().isSuccess());
        if (response.getBody().isSuccess()) {
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

        restTemplate.setErrorHandler(new ResponseErrorHandler() {
            @Override
            public boolean hasError(ClientHttpResponse clientHttpResponse) throws IOException {
                return false;
            }

            @Override
            public void handleError(ClientHttpResponse clientHttpResponse) throws IOException {

            }
        });
        ResponseEntity<SuccessEntity> entity = restTemplate.postForEntity(
                ServerProperties.modelUrl + "/users/check_password",
                login,
                SuccessEntity.class);
        return entity.getBody().isSuccess();
    }

}
