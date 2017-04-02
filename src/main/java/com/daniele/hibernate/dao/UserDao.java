package com.daniele.hibernate.dao;

import java.util.List;

import com.daniele.hibernate.model.UserAccount;

public interface UserDao{
	UserAccount getUserById(long id);
	int countUsers();
	List<UserAccount> getAllUsers();
	List<UserAccount> getUsersLike(String likeString);
	void saveUser(UserAccount user);
}