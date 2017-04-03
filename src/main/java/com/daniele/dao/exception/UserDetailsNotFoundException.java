package com.daniele.dao.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="This User cannot be found in the system")
public class UserDetailsNotFoundException  extends Exception {
	private static final long serialVersionUID = 100L;
	private String description;
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
}