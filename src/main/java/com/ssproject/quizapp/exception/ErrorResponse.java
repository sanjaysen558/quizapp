package com.ssproject.quizapp.exception;

public class ErrorResponse {
	private String message;
	private String detail;
    private int statusCode;
    
    public ErrorResponse(String message, String detail,int statusCode) {
        this.message = message;
        this.statusCode = statusCode;
        this.detail = detail;
    }

	public String getMessage() {
		return message;
	}

	public String getDetail() {
		return detail;
	}

	public int getStatusCode() {
		return statusCode;
	}

	
    


}