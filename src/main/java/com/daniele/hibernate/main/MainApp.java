package com.daniele.hibernate.main;

import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.daniele.hibernate.dao.exception.UserDetailsNotFoundException;
import com.daniele.hibernate.model.Address;
import com.daniele.hibernate.model.UserDetails;
import com.daniele.hibernate.service.impl.UserDetailsServiceImpl;

public class MainApp {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:WEB-INF/applicationContext.xml");
		UserDetailsServiceImpl userDetailsService = (UserDetailsServiceImpl) context.getBean("userDetailsServiceImpl");
		
		for (int i = 1; i <= 5; i++) {
			Address address = new Address();
			address.setCity("City" + i);
			address.setStreet("Dummy Street N." + i);
			address.setZipcode("9009" + i);
			
			UserDetails user = new UserDetails();
			user.setName("User" + i);
			user.setDescription("Description field " + i);
			user.setAddress(address);
			user.setJoinDate(new Date());
			
			address.setUserDetails(user);
			
			userDetailsService.saveUserDetails(user);
			System.out.println("Saving user" + i);
		}
				
		try {
			UserDetails user = userDetailsService.getUserById(1);
			System.out.println(user.toString());
		} catch (UserDetailsNotFoundException e) {
			e.printStackTrace();
		}
		
		((ClassPathXmlApplicationContext) context).close();
	}
}