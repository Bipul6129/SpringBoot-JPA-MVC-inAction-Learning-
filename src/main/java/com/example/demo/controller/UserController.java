package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.User;
import com.example.demo.error.FieldMandatoryException;
import com.example.demo.error.UserNotFoundException;
import com.example.demo.service.UserServiceImpl;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserServiceImpl userService;
	
	@GetMapping("/getAll")
	public List<User> getAllUsers() throws UserNotFoundException{
		return userService.getAllUsers();
	}
	
	@PostMapping("/save")
	public User saveUser(@RequestBody User u) throws FieldMandatoryException {
		return userService.inserUser(u);
	}
	
	@DeleteMapping("/delete/{id}")
	public HttpStatus deleteUser(@PathVariable("id") Long userId) throws UserNotFoundException {
		userService.deleteUser(userId);
		return HttpStatus.OK;
		
	}
	
	@PutMapping("/update")
	public User updateUser(@RequestBody User u) throws UserNotFoundException, FieldMandatoryException {
		return userService.updateUser(u);
	}
	
	@GetMapping("/{id}")
	public User getUser(@PathVariable("id") Long id) throws UserNotFoundException {
		return userService.getUser(id);
	}
	
}
