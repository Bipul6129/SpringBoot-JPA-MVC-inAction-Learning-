package com.example.demo.error;

public class BlogNotFoundException extends Exception{

	private static final long serialVersionUID = 1L;

	public BlogNotFoundException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BlogNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public BlogNotFoundException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public BlogNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public BlogNotFoundException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	
	

}
