/**
 * 
 */
package com.uxpsystems.assignment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.uxpsystems.assignment.exception.UserException;
import com.uxpsystems.assignment.representation.JsonErrorResponse;
import com.uxpsystems.assignment.representation.JsonResponse;
import com.uxpsystems.assignment.representation.User;
import com.uxpsystems.assignment.service.UserService;

/**
 * @author Abhishek
 *
 */
@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/users/{id}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<? extends JsonResponse> getUser(@PathVariable(value = "id") long id) {
		User user;
		try {
			user = userService.getUserById(id);
			return ResponseEntity.ok(user);
		} catch (UserException e) {
			return new ResponseEntity<JsonErrorResponse>(new JsonErrorResponse(e.getErrorMessage(), e.getRemediation()),
					HttpStatus.NOT_FOUND);
		}

	}

	@RequestMapping(value = "/users", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List<User>> getAllUsers() {
		List<User> users = userService.getAllUsers();
		return ResponseEntity.ok(users);
	}

	@RequestMapping(value = "/users", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	public ResponseEntity<? extends JsonResponse> createUser(@RequestBody User user) {

		try {
			return new ResponseEntity<User>(userService.createUser(user), HttpStatus.CREATED);
		} catch (UserException e) {
			return new ResponseEntity<JsonErrorResponse>(new JsonErrorResponse(e.getErrorMessage(), e.getRemediation()),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(value = "/users/{id}", method = RequestMethod.PUT, produces = "application/json", consumes = "application/json")
	public ResponseEntity<? extends JsonResponse> updateUser(@RequestBody User user) {

		try {
			return new ResponseEntity<User>(userService.updateUser(user), HttpStatus.OK);
		} catch (UserException e) {
			return new ResponseEntity<JsonErrorResponse>(new JsonErrorResponse(e.getErrorMessage(), e.getRemediation()),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)
	public void deleteUser(@PathVariable(value = "id") long id) throws UserException {

		userService.deleteUser(id);

	}

}
