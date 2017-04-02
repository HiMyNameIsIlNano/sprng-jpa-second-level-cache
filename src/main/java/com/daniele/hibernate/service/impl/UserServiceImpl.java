package com.daniele.hibernate.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.daniele.hibernate.dao.UserDao;
import com.daniele.hibernate.dao.exception.UserDetailsNotFoundException;
import com.daniele.hibernate.model.UserAccount;
import com.daniele.hibernate.service.UserService;

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
}