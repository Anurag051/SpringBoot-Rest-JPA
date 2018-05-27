package com.anurag.user;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class UserResource {
	@Autowired
	private UserServiceDAO serviceDAO;

	@GetMapping(path = "/users")
	public List<User> getAllUsers() {
		return serviceDAO.findAll();
	}

	@GetMapping(path = "/users/{id}")
	public User getUser(@PathVariable int id) {
		User user=serviceDAO.findOne(id);
		if (user==null) {
			throw new UserNotFoundException("ID-"+id);
		}
		return user;
	}

	@PostMapping(path = "/users")
	public ResponseEntity<Object> addUser(@RequestBody User user) {
		User savedUser = serviceDAO.saveUser(user);
		// Created Status
		// URI => /users/4
		URI location=ServletUriComponentsBuilder.
		fromCurrentRequest().path("/{id}").
		buildAndExpand(savedUser.getId()).toUri();
		return ResponseEntity.created(location).build();
	}

}
