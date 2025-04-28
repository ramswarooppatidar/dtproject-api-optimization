package com.deepthought.yardapi.error;

import org.springframework.stereotype.Component;

@Component
public class ErrorResponse {
	private String errorMessage;
	private String statusCode;
	
	public ErrorResponse(String errorMessage, String statusCode) {
		super();
		this.errorMessage = errorMessage;
		this.statusCode = statusCode;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public String getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}
	
}
