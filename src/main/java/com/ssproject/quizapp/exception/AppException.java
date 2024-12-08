package com.ssproject.quizapp.exception;

import org.springframework.http.HttpStatus;


public class AppException extends RuntimeException {
	private HttpStatus httpStatus;
	private String errDetail;
	
	public AppException(String errMsg,String errDetail, HttpStatus httpStatus) {
		super(errMsg);
		this.httpStatus = httpStatus;
		this.errDetail = errDetail;
	}
	
	public HttpStatus getHttpStatus() {
		return httpStatus;
	}
	
	public String getErrDetail() {
		return errDetail;
	}
}
