package com.daniele.hibernate.dao;

import java.util.List;

import com.daniele.hibernate.model.UserDetails;

public interface UserDetailsDao{
	UserDetails getUserById(long id);
	int countUsers();
	List<UserDetails> getAllUsers();
	List<UserDetails> getUsersLike(String likeString);
	void saveUserDetails(UserDetails userDetails);
}