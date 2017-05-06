package fii.admission.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
public class StatsController {
	@RequestMapping(value="/version", method = RequestMethod.GET)
	public String getVersion() {
		return "{\"version\": \"1.0\"}";
	}
}
