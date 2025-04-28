package com.deepthought.yardapi.customException;

public class SlotNotFoundException extends RuntimeException {
	public SlotNotFoundException(String msg) {
		super(msg);
	}
}
