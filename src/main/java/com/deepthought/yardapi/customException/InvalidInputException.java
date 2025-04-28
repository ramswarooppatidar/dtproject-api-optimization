package com.deepthought.yardapi.customException;

public class InvalidInputException extends RuntimeException {
	public InvalidInputException(String msg) {
		super(msg);
	}
}
