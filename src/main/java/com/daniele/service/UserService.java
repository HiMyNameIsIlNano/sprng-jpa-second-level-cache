package com.daniele.service;

import java.util.List;

import com.daniele.dao.exception.UserDetailsNotFoundException;
import com.daniele.model.UserAccount;

public interface UserService {
	UserAccount getUserById(long id) throws UserDetailsNotFoundException;
	int countUsers();
	List<UserAccount> getAllUsers();
	void saveUser(UserAccount user);
	List<UserAccount> getUsersLike(String stringLike);
}