package fii.admission.users;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value = "/model")
@RestController
public class UserController {

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public ResponseEntity<List<User>> getAllUser() {
        System.out.print("[debug][getAllUser] ");
        List<User> result = UserService.getAllUser();
        System.out.println(result.size() + " entries");

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
    public ResponseEntity<Success> checkEmail(@RequestBody Email email) {
        System.out.print("[debug][checkEmail] " + email.getEmail() + " => ");
        User result = UserService.getUser(email.getEmail());
        System.out.println(result);

        if (result == null) {
            return new ResponseEntity<Success>(new Success(true), HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<Success>(new Success(false), HttpStatus.OK);
        }
    }

    @RequestMapping(value = "/users/delete_user", method = RequestMethod.POST)
    public ResponseEntity<Success> deleteUser(@RequestBody Email email) {
        System.out.print("[debug][deleteUser] " + email.getEmail() + " => ");
        int result = UserService.deleteUser(email.getEmail());
        System.out.println(result);

        if (result == 1) {
            return new ResponseEntity<Success>(new Success(true), HttpStatus.OK);
        } else {
            return new ResponseEntity<Success>(new Success(false), HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/users/add_user", method = RequestMethod.POST)
    public ResponseEntity<Success> insertUser(@RequestBody User user) {
        System.out.print("[debug][insertUser] " + user.toString() + " => ");
        int result = UserService.insertUser(user);
        System.out.println(result);

        if (result == 0)
            return new ResponseEntity<Success>(new Success(false), HttpStatus.NOT_MODIFIED);
        else
            return new ResponseEntity<Success>(new Success(true), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/users/is_logged_in", method = RequestMethod.POST)
    public ResponseEntity<Success> isLoggedIn(@RequestBody UserIn user) {
        System.out.print("[debug][isLoggedIn] " + user.toString() + " => ");
        if (UserService.isLogged(user)) {
            System.out.println("User logged in");
            return new ResponseEntity<Success>(new Success(true), HttpStatus.OK);
        } else {
            System.out.println("User not logged in");
            return new ResponseEntity<Success>(new Success(false), HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/users/set_token", method = RequestMethod.POST)
    public ResponseEntity<Success> setToken(@RequestBody SetTokenEntity ust) {
        System.out.print("[debug][setToken] " + ust.toString() + " => ");
        if (UserService.updateToken(ust)) {
            System.out.println("Updated");
            return new ResponseEntity<Success>(new Success(true), HttpStatus.OK);
        } else {
            System.out.println("Not updated");
            return new ResponseEntity<Success>(new Success(false), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/users/get_role/{token}", method = RequestMethod.GET)
    public ResponseEntity<RoleEntity> getRole(@PathVariable("token") String token) {
        System.out.print("[debug][getRole] token: " + token + " => ");
        RoleEntity role = UserService.getRole(token);
        System.out.println(role.getRole());

        if (role != null) {
            return new ResponseEntity<RoleEntity>(role, HttpStatus.OK);
        } else {
            return new ResponseEntity<RoleEntity>(role, HttpStatus.NOT_FOUND);
        }
    }
}
