package fii.admission.users;

import java.util.Arrays;
import java.util.Base64;
import java.util.List;

import fii.admission.DTO.SuccessEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = "/model")
@RestController
public class UserController {

	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public ResponseEntity<List<User>> getAllUser() {
		List<User> result = UserService.getAllUser();

		if (result == null)
			return new ResponseEntity<List<User>>(result, HttpStatus.NO_CONTENT);

		return new ResponseEntity<List<User>>(result, HttpStatus.OK);
	}

	@RequestMapping(value = "/users/get_user/{emailB64}", method = RequestMethod.GET)
	public ResponseEntity<User> getUser(@PathVariable String emailB64) {
        System.out.println(emailB64);
        String email = new String(Base64.getDecoder().decode(emailB64.getBytes()));
		System.out.print("[debug][getUser] " + email + " => ");
		User result = UserService.getUser(email);
		System.out.println(result);

		if (result == null)
			return new ResponseEntity<User>(result, HttpStatus.NOT_FOUND);

		return new ResponseEntity<User>(result, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/users/check_email", method = RequestMethod.POST)
	public ResponseEntity<SuccessEntity> checkEmail(@RequestBody Email email) {
		User result = UserService.getUser(email.getEmail());

		if(result == null) {
			return new ResponseEntity<>(new SuccessEntity(true), HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity<>(new SuccessEntity(false), HttpStatus.OK);
		}
	}

	@RequestMapping(value = "/users/add_user", method = RequestMethod.POST)
	public ResponseEntity<SuccessEntity> insertUser(@RequestBody User user) {
		int result = UserService.insertUser(user);

		if(result == 0)
			return new ResponseEntity<>(new SuccessEntity(false), HttpStatus.BAD_REQUEST);
		else 
			return new ResponseEntity<>(new SuccessEntity(true), HttpStatus.CREATED);
	}

	@RequestMapping(value="/users/check_password", method = RequestMethod.POST)
	public ResponseEntity<SuccessEntity> checkPassword(@RequestBody UserIn user){
		if (UserService.isLogged(user)) {
			System.out.println("[debug][checkPassword] User is logged!");
			return new ResponseEntity<>(new SuccessEntity(true),HttpStatus.OK);
		}else{
			System.out.println("[debug][checkPassword] User is not logged!");
			return new ResponseEntity<>(new SuccessEntity(false), HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(value="/users/set_token", method = RequestMethod.POST)
	public ResponseEntity<SuccessEntity> updateToken(@RequestBody SetTokenEntity ust) {
		if (UserService.updateToken(ust)) {
			System.out.println("Updated");
			return new ResponseEntity<>(new SuccessEntity(true), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(new SuccessEntity(false), HttpStatus.BAD_REQUEST);
		}
	}

}

