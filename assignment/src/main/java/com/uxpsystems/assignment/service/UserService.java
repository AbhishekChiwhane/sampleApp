package com.uxpsystems.assignment.service;

import java.util.List;

import com.uxpsystems.assignment.exception.UserException;
import com.uxpsystems.assignment.representation.User;

public interface UserService {
	
	public List<User> getAllUsers();
	public User getUserById(long id) throws UserException;
	public User createUser(User user) throws UserException;
	public User updateUser(User user) throws UserException;
	public void deleteUser(long id) throws UserException;

}
