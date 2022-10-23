package com.example.learn.exception;

public class UserNotFoundException extends RuntimeException {

	public UserNotFoundException(String msg){
		super(msg);
	}

}
