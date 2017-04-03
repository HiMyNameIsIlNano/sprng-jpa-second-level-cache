package com.daniele.test;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.daniele.dao.exception.UserDetailsNotFoundException;
import com.daniele.service.UserService;
import com.daniele.shared.JsonUtils;

public class JsonHelperTest extends BaseJUnitTest{
	
	@Autowired
	private UserService userService;
	
	@Test
	public void postMethodJsonRequest() throws UserDetailsNotFoundException {
		System.out.println(JsonUtils.prettyJsonString(userService.getUserById(1)));
	}
}
