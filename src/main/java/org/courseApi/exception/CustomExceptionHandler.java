package org.courseApi.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8193569963997939487L;
	
	@ExceptionHandler(TopicNotFoundException.class)
	public ResponseEntity<ErrorMessage> exception(TopicNotFoundException ex) {
		ErrorMessage errorMessage= new ErrorMessage(ex.getStatusCode(),ex.getMessage(),ex.getMessage());
		return ResponseEntity.status(404).body(errorMessage);
	}
	
	@ExceptionHandler(CourseNotFoundException.class)
	public ResponseEntity<ErrorMessage> exception(CourseNotFoundException ex){
		ErrorMessage errorMessage= new ErrorMessage(ex.getStatusCode(),ex.getMessage(),ex.getMessage());
		return ResponseEntity.status(404).body(errorMessage);		
	}
	
	

}
