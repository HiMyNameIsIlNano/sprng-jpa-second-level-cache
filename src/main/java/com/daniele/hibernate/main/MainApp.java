package com.daniele.hibernate.main;

import java.time.LocalDate;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.daniele.hibernate.dao.exception.UserDetailsNotFoundException;
import com.daniele.hibernate.model.Address;
import com.daniele.hibernate.model.UserAccount;
import com.daniele.hibernate.service.impl.UserServiceImpl;

public class MainApp {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:WEB-INF/applicationContext.xml");
		UserServiceImpl userDetailsService = (UserServiceImpl) context.getBean("userServiceImpl");
		
		for (int i = 1; i <= 5; i++) {
			Address address = new Address.AddressBuilder()
					.withCity("City " + i)
					.withStreet("Dummy Street")
					.withStreetNumber((short )i)
					.withZipCode("9009" + i)
					.build();
					
			UserAccount user = new UserAccount.UserBuilder()
					.withName("User" + i)
					.withDescription("Description field " + i)
					.withAddress(address)
					.withJoinDate(LocalDate.now())
					.build();
			
			userDetailsService.saveUser(user);
			System.out.println("Saving user" + i);
		}
				
		try {
			UserAccount user = userDetailsService.getUserById(1);
			System.out.println(user.toString());
		} catch (UserDetailsNotFoundException e) {
			e.printStackTrace();
		}
		
		((ClassPathXmlApplicationContext) context).close();
	}
}