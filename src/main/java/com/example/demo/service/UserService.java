package com.example.demo.service;
import java.util.List;

import com.example.demo.entity.*;
import com.example.demo.error.FieldMandatoryException;
import com.example.demo.error.UserNotFoundException;
public interface UserService {
	public List<User> getAllUsers() throws UserNotFoundException;
	public User inserUser(User u) throws FieldMandatoryException;
	public void deleteUser(Long userId) throws UserNotFoundException;
	public User updateUser(User u) throws UserNotFoundException,FieldMandatoryException;
	public User getUser(Long id) throws UserNotFoundException;
}
