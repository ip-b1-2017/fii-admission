package com.ip_b1.fii.admission.Controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/licenta/login")
public class Login {

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<LoginDTO> checkCredentials(@RequestBody LoginDTO login) {
		if (!check(login)) {
			System.out.println("Giosanu si " + login.getPassword());
			return new ResponseEntity<LoginDTO>(HttpStatus.NOT_FOUND);
		} else
			System.out.println("Giosanu si " + login.getPassword() + " " +login.getFamilia_giosanu());
		login.setPassword("hello");
		return new ResponseEntity<LoginDTO>(login, HttpStatus.OK);
	}

	private static boolean check(LoginDTO login) {
		if (login.getUsername().equals("giosanu") && login.getPassword().equals("mama_lui_giosanu"))
			return true;
		else
			return false;
	}

}
