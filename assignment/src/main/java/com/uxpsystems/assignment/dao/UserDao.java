package com.uxpsystems.assignment.dao;

import java.util.List;

import com.uxpsystems.assignment.entity.UserEntity;
import com.uxpsystems.assignment.exception.UserException;
import com.uxpsystems.assignment.representation.User;

public interface UserDao {
	
	  public List<UserEntity> getAllUsers(); 
	  public UserEntity getUserById(long id) throws UserException; 
	  public long createUser(User user) throws UserException;
	  public void updateUser(User user) throws UserException; 
	  public void deleteUser(long id) throws UserException;
	 

}
