package com.anurag.user;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1663099601909567504L;

	public UserNotFoundException(String arg0) {
		super(arg0);
	}
	
	

}
