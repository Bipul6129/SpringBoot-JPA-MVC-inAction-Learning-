package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.error.FieldMandatoryException;
import com.example.demo.error.UserNotFoundException;
import com.example.demo.repository.UserRepo;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserRepo userRepo;
	@Override
	public List<User> getAllUsers() throws UserNotFoundException {
		// TODO Auto-generated method stub
		List<User> users = userRepo.findAll();
		if(users.isEmpty()) {
			throw new UserNotFoundException("user not available");
		}
		return users;
	}
	@Override
	public User inserUser(User u) throws FieldMandatoryException {
		// TODO Auto-generated method stub
		if(u.getUsername()==null||u.getUsername().equals("")) {
			throw new FieldMandatoryException("username field is manadatory");
		}
		return userRepo.save(u);
	}
	@Override
	public void deleteUser(Long userId) throws UserNotFoundException {
		// TODO Auto-generated method stub
		Optional<User> userList = userRepo.findById(userId);
		if(userList.isEmpty()) {
			throw new UserNotFoundException("user not found");
		}
		
		userRepo.deleteById(userId);
		
	}

	@Override
	public User updateUser(User u) throws UserNotFoundException, FieldMandatoryException {
		if(u.getId()==null) {
			throw new FieldMandatoryException("user cannot be identified");
		}
		Optional<User> userList = userRepo.findById(u.getId());
		if(userList.isEmpty()) {
			throw new UserNotFoundException("user not found");
		}
		if(u.getUsername()==null ||u.getUsername().trim().equals("")) {
			throw new FieldMandatoryException("username field is mandatory");
		}
		User oldU = userList.get();
		oldU.setUsername(u.getUsername());
		return userRepo.save(oldU);
	}
	
	@Override
	public User getUser(Long id) throws UserNotFoundException {
		Optional<User> userList = userRepo.findById(id);
		if(userList.isEmpty()) {
			throw new UserNotFoundException("user not found");
		}
		
		// TODO Auto-generated method stub
		return userList.get();
	}
	
	

}
