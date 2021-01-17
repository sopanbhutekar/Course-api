package org.courseApi.exception;


public class TopicNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8193569963997939487L;
	
	private String message;
	private int statusCode;

	public TopicNotFoundException(String message, int statusCode) {
		super();
		this.message = message;
		this.statusCode = statusCode;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public TopicNotFoundException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TopicNotFoundException(String message) {
		super(message);
		this.message=message;
	}
	
	
	

}
