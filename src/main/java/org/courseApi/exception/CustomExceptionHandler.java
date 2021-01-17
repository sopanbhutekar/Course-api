package org.courseApi.exception;


import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
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
	
	@Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(
			HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
		ErrorMessage errorMessage= new ErrorMessage(status.value(),ex.getMessage(),ex.getStackTrace().toString());
		return ResponseEntity.badRequest().body(errorMessage);
	}
	
	@Override
	protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(
			HttpRequestMethodNotSupportedException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
		ErrorMessage errorMessage= new ErrorMessage(status.value(),ex.getMessage(),ex.getStackTrace().toString());
		return ResponseEntity.badRequest().body(errorMessage);
	}
}
