package com.daniele.hibernate.service;

import java.util.List;

import com.daniele.hibernate.model.UserDetails;

public interface UserDetailsService {
	UserDetails getUserById(long id);
	int countUsers();
	List<UserDetails> getAllUsers();
	void saveUserDetails(UserDetails userDetails);
	List<UserDetails> getUsersLike(String stringLike);
}