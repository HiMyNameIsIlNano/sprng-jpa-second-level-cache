package com.daniele.dao;

import java.util.List;

import com.daniele.model.UserAccount;

public interface UserDao{
	UserAccount getUserById(long id);
	int countUsers();
	List<UserAccount> getAllUsers();
	List<UserAccount> getUsersLike(String likeString);
	UserAccount getUserByEmail(String email);
	void saveUser(UserAccount user);
}