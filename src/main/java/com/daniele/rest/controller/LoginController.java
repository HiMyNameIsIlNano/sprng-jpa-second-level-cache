package com.daniele.rest.controller;

import java.util.UUID;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.daniele.model.UserAccount;
import com.daniele.rest.dto.AuthRequest;
import com.daniele.rest.dto.AuthResponse;
import com.daniele.service.UserService;

@Controller
@EnableWebMvc
public class LoginController {

	@Autowired
	private UserService userService;

	// Logger
	private final static Logger LOGGER = Logger.getLogger(LoginController.class.getName());

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<AuthResponse> doLogin(@RequestBody AuthRequest request) {
		HttpStatus result = HttpStatus.NOT_FOUND;
		UserAccount user = null;
		AuthResponse response = new AuthResponse(null, -1L);
		try {
			user = userService.getUserByEmail(request.getEmail());
			if (user != null) {
				response.setToken(issueToken(user.getName()));
				response.setUserId(user.getId());
				result = user.getPassword().equals(request.getPassword()) ? HttpStatus.OK : HttpStatus.NOT_FOUND;
			}
		} catch (Exception e) {
			LOGGER.warning(e.getLocalizedMessage());
		}
		return new ResponseEntity<AuthResponse>(response, result);
	}

	private String issueToken(String username) {
		// Issue a token (can be a random String persisted to a database or a JWT token)
		// The issued token must be associated to a user
		// Return the issued token
		return username != null ? UUID.randomUUID().toString() : null;
	}
}
