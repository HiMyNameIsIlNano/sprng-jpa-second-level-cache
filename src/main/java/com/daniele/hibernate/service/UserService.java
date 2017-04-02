package com.daniele.hibernate.service;

import java.util.List;

import com.daniele.hibernate.dao.exception.UserDetailsNotFoundException;
import com.daniele.hibernate.model.UserAccount;

public interface UserService {
	UserAccount getUserById(long id) throws UserDetailsNotFoundException;
	int countUsers();
	List<UserAccount> getAllUsers();
	void saveUser(UserAccount user);
	List<UserAccount> getUsersLike(String stringLike);
}