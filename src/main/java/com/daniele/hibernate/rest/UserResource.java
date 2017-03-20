package com.daniele.hibernate.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.daniele.hibernate.dao.exception.UserDetailsNotFoundException;
import com.daniele.hibernate.model.UserDetails;
import com.daniele.hibernate.service.UserDetailsService;

@Controller
@EnableWebMvc
public class UserResource {

	@Autowired
	UserDetailsService userDetailsService;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET) 
	@ResponseBody
    public UserDetails getUserDetails( @PathVariable("id") Integer id) throws UserDetailsNotFoundException {
		return userDetailsService.getUserById(id); 
     }

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@ResponseBody
	public void saveUserDetails(@RequestBody UserDetails userDetails) {
		System.out.println(userDetails.toString());
	}
}