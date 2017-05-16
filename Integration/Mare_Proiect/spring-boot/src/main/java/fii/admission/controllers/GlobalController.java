package fii.admission.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GlobalController {

    @RequestMapping(value = "/status", method = RequestMethod.GET)
    public String getVersion() {
        // TODO -> statistici despre db-uri
        return "I'm still alive...";
    }

}
