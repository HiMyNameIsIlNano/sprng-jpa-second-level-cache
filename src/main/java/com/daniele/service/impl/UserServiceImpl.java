package com.daniele.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.daniele.dao.UserDao;
import com.daniele.dao.exception.UserDetailsNotFoundException;
import com.daniele.model.UserAccount;
import com.daniele.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserDao userDao;
	
	@Override
	@Transactional
	public void saveUser(UserAccount user) { 
		userDao.saveUser(user);
	}
	
	@Override
	@Transactional(readOnly = true)
	public UserAccount getUserById(long id) throws UserDetailsNotFoundException {
		try {
			return userDao.getUserById(id);
		} catch (Exception e) {
			throw new UserDetailsNotFoundException();
		}
	}
	
	@Override
	@Transactional(readOnly = true)
	public int countUsers() {
		return userDao.countUsers();
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<UserAccount> getAllUsers() {
		return userDao.getAllUsers();
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<UserAccount> getUsersLike(String stringLike) {
		return userDao.getUsersLike(stringLike);
	}
	
	@Override
	@Transactional(readOnly = true)
	public UserAccount getUserByEmail(String email) {
		return userDao.getUserByEmail(email);
	}
}