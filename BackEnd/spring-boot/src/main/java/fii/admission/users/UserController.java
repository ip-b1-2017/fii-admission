package fii.admission.users;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public ResponseEntity<List<User>> getAllUser() {
		List<User> result = UserService.getAllUser();

		if (result == null)
			return new ResponseEntity<List<User>>(result, HttpStatus.NO_CONTENT);

		return new ResponseEntity<List<User>>(result, HttpStatus.OK);
	}

	@RequestMapping(value = "/users/{email}", method = RequestMethod.GET)
	public ResponseEntity<User> getUser(@PathVariable String email) {
		User result = UserService.getUser(email);

		if (result == null)
			return new ResponseEntity<User>(result, HttpStatus.NOT_FOUND);

		return new ResponseEntity<User>(result, HttpStatus.OK);
	}

	@RequestMapping(value = "/users/{email}", method = RequestMethod.POST)
	public ResponseEntity<Integer> updateUser(@PathVariable("email") String email, @RequestBody User user) {
		int result = UserService.updateUser(email, user);
		if (result == 0)
			return new ResponseEntity<Integer>(result, HttpStatus.NOT_MODIFIED);
		else
			return new ResponseEntity<Integer>(result, HttpStatus.OK);
	}

	@RequestMapping(value = "/users/{email}", method = RequestMethod.DELETE)
	public ResponseEntity<Integer> deleteUser(@PathVariable("email") String email) {
		int result = UserService.deleteUser(email);
		if (result == 0)
			return new ResponseEntity<Integer>(result, HttpStatus.NOT_MODIFIED);
		else
			return new ResponseEntity<Integer>(result, HttpStatus.OK);
	}

	@RequestMapping(value = "/users", method = RequestMethod.PUT)
	public ResponseEntity<Integer> insertUser(@RequestBody User user) {
		int result = UserService.insertUser(user);
		if (result == 0)
			return new ResponseEntity<Integer>(result, HttpStatus.NOT_MODIFIED);
		else
			return new ResponseEntity<Integer>(result, HttpStatus.OK);
	}
}
