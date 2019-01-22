package com.uxpsystems.assignment.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uxpsystems.assignment.dao.UserDao;
import com.uxpsystems.assignment.entity.UserEntity;
import com.uxpsystems.assignment.exception.UserException;
import com.uxpsystems.assignment.representation.User;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao userDao;

	@Override
	public List<User> getAllUsers() {
		List<UserEntity> entities = userDao.getAllUsers();
		List<User> users = new ArrayList<>();
		entities.forEach(entity -> users.add(convertToRepresentation(entity)));
		return users;
	}

	@Override
	public User getUserById(long id) throws UserException {
		UserEntity entity = userDao.getUserById(id);
		return convertToRepresentation(entity);

	}

	@Override
	public User createUser(User user) throws UserException {
		long id = userDao.createUser(user);
		return getUserById(id);
	}

	@Override
	public User updateUser(User user) throws UserException {
		getUserById(user.getId());
		userDao.updateUser(user);
		return getUserById(user.getId());
	}

	@Override
	public void deleteUser(long id) throws UserException {
		userDao.deleteUser(id);

	}

	private User convertToRepresentation(UserEntity entity) {
		User user = new User();
		user.setId(entity.getId());
		user.setUsername(entity.getName());
		user.setPassword(entity.getPassword().toCharArray());
		user.setUserStatus(entity.getStatus());
		return user;

	}

}
