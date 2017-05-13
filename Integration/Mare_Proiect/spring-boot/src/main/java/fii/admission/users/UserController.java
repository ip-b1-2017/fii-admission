
package fii.admission.users;

/**
 *
 * @author Asus*/

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value ="/model")
public class UserController {
	/*
	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public ResponseEntity<List<User>> getAllUser() {
		List<User> result = UserService.getAllUser();
		
		if(result == null)
			return new ResponseEntity<List<User>>(result, HttpStatus.NO_CONTENT);
		
		return new ResponseEntity<List<User>>(result, HttpStatus.OK);
	}
	*/
	
	@RequestMapping(value = "/check_email/{email}", method = RequestMethod.GET)
	public ResponseEntity<Success> checkEmail(@PathVariable("email") String email) {
		User result = UserService.getUser(email);
		System.out.println("error");
		if(result == null) {
			return new ResponseEntity<Success>(new Success(true), HttpStatus.OK);
		}else {
			return new ResponseEntity<Success>(new Success(false), HttpStatus.OK);
		}
	}
	/*
	@RequestMapping(value = "/users/{email}", method = RequestMethod.POST)
	public ResponseEntity<Integer> updateUser(@PathVariable("email") String email, @RequestBody User user) {
		int result = UserService.updateUser(email, user);
		if(result == 0)
			return new ResponseEntity<Integer>(result, HttpStatus.NOT_MODIFIED);
		else 
			return new ResponseEntity<Integer>(result, HttpStatus.OK);
	}
	*/
	/*
	@RequestMapping(value = "/users/{email}", method = RequestMethod.DELETE)
	public ResponseEntity<Integer> deleteUser(@PathVariable("email") String email) {
		int result = UserService.deleteUser(email);
		if(result == 0)
			return new ResponseEntity<Integer>(result, HttpStatus.NOT_MODIFIED);
		else 
			return new ResponseEntity<Integer>(result, HttpStatus.OK);
	}
	*/
	@RequestMapping(value = "/add_user", method = RequestMethod.POST)
	public ResponseEntity<Success> insertUser(@RequestBody User user) {
		System.out.println("error super big");
		int result = UserService.insertUser(user);
		System.out.println("error super big");
		if(result == 0)
			return new ResponseEntity<Success>(new Success(false), HttpStatus.NOT_MODIFIED);
		else 
			return new ResponseEntity<Success>(new Success(true), HttpStatus.CREATED);
	}
}

