package fiiadmission.view.controller;

import fiiadmission.ServerProperties;
import fiiadmission.view.Model.Announcement;
import org.springframework.http.*;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.ResponseErrorHandler;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;

/**
 * Created by cosmin on 6/12/2017.
 */
@Controller
@RequestMapping("/view/announcements")
public class AnnouncementsController {
    @RequestMapping(value="", method = RequestMethod.GET)
    public ResponseEntity <List<Announcement>> getFirstAdsSet(){
        System.out.println("penis");
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
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
        UriComponentsBuilder builder =  builder = UriComponentsBuilder.fromHttpUrl(ServerProperties.modelUrl + "/announcements")
                .queryParam("limit","5").queryParam("limit",4);
        System.out.println(builder.toUriString());
        HttpEntity<?> entity = new HttpEntity<>(headers);
        ResponseEntity<Announcement[]> response = restTemplate.exchange(
                builder.build().encode().toUri(),
                HttpMethod.GET,
                entity,
                Announcement[].class);
        ArrayList<Announcement> arraylist = new ArrayList<Announcement>(Arrays.asList(response.getBody()));
        return new ResponseEntity<>(arraylist,response.getStatusCode());
    }
}
