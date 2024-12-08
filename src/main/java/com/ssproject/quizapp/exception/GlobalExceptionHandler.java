package com.ssproject.quizapp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	// Handle specific AppException
    @ExceptionHandler(AppException.class)
    public ResponseEntity<ErrorResponse> handleAppException(AppException ex) {
        ErrorResponse error = new ErrorResponse(ex.getMessage(),ex.getErrDetail(), ex.getHttpStatus().value());
        return new ResponseEntity<>(error, ex.getHttpStatus());
    }
    
    // Handle generic Exception
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGenericException(Exception ex, WebRequest request){
    	ErrorResponse error = new ErrorResponse("Something went wrong",ex.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR.value());
    	ex.printStackTrace();
    	return new ResponseEntity<>(error,HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
