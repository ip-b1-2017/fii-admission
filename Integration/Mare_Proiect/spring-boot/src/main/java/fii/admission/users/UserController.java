package fii.admission.users;

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

	@RequestMapping(value = "/users/get_user", method = RequestMethod.POST)
	public ResponseEntity<User> getUser(@RequestBody Email email) {
		System.out.print("[debug][getUser] " + email.getEmail() + " => ");
		User result = UserService.getUser(email.getEmail());
		System.out.println(result.toString());

		if (result == null)
			return new ResponseEntity<User>(result, HttpStatus.NO_CONTENT);

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
			return new ResponseEntity<>(new SuccessEntity(false), HttpStatus.NOT_MODIFIED);
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
			return new ResponseEntity<>(new SuccessEntity(false), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

    @RequestMapping(value="/users/get_role/{token}", method = RequestMethod.GET)
    public ResponseEntity<RoleEntity> getRole(@PathVariable("token") String token) {
        RoleEntity role = UserService.getRole(token);
        if (role!=null) {
            return new ResponseEntity<RoleEntity>(role, HttpStatus.OK);
        } else {
            return new ResponseEntity<RoleEntity>(role, HttpStatus.NOT_FOUND);
        }
    }

}

