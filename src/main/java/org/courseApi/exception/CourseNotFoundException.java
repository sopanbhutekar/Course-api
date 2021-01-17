package org.courseApi.exception;

public class CourseNotFoundException extends RuntimeException{

	private int statusCode;
	private String message;
	public CourseNotFoundException() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CourseNotFoundException(String message) {
		super(message);
		this.message=message;
	}
	public CourseNotFoundException(int statusCode, String message) {
		super();
		this.statusCode = statusCode;
		this.message = message;
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
}
