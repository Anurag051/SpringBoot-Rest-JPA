package com.anurag.helloworld;

public class HelloWorldBean {

	private String message;

	public HelloWorldBean(String msg) {
		this.message=msg;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	public String getMessage() {
		return message;
	}

	@Override
	public String toString() {
		return "HelloWorldBean [message=" + message + "]";
	}
	
	
	

}
