package com.daniele.hibernate.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.daniele.hibernate.dao.UserDetailsDao;
import com.daniele.hibernate.dao.exception.UserDetailsNotFoundException;
import com.daniele.hibernate.model.UserDetails;
import com.daniele.hibernate.service.UserDetailsService;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	UserDetailsDao userDetailsDao;
	
	@Override
	@Transactional
	public void saveUserDetails(UserDetails userDetails) { 
		userDetailsDao.saveUserDetails(userDetails);
	}
	
	@Override
	@Transactional(readOnly = true)
	public UserDetails getUserById(long id) throws UserDetailsNotFoundException {
		try {
			return userDetailsDao.getUserById(id);
		} catch (Exception e) {
			throw new UserDetailsNotFoundException();
		}
	}
	
	@Override
	@Transactional(readOnly = true)
	public int countUsers() {
		return userDetailsDao.countUsers();
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<UserDetails> getAllUsers() {
		return userDetailsDao.getAllUsers();
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<UserDetails> getUsersLike(String stringLike) {
		return userDetailsDao.getUsersLike(stringLike);
	}
}