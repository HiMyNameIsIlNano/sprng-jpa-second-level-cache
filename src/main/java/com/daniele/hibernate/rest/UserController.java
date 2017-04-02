package com.daniele.hibernate.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.daniele.hibernate.dao.exception.UserDetailsNotFoundException;
import com.daniele.hibernate.model.UserAccount;
import com.daniele.hibernate.service.UserService;

@Controller
@EnableWebMvc
public class UserController {

	@Autowired
	UserService userService;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET) 
	@ResponseBody
	public UserAccount getUser( @PathVariable("id") Integer id) throws UserDetailsNotFoundException {
		return userService.getUserById(id); 
     }

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ResponseEntity<UserAccount> saveUser(@RequestBody UserAccount user) {
	    if (user != null) {
	    	userService.saveUser(user);
	    }
	    return new ResponseEntity<UserAccount>(user, HttpStatus.OK);
	}
}