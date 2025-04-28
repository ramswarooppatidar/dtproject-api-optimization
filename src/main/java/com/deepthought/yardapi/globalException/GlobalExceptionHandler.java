package com.deepthought.yardapi.globalException;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.deepthought.yardapi.customException.InvalidInputException;
import com.deepthought.yardapi.customException.SlotNotFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(InvalidInputException.class)
	public ResponseEntity<Map<String, Object>> hanldeInvalidInputException(InvalidInputException ex){
		Map<String, Object> response = new HashMap<>();
		response.put("timeStamp", LocalDateTime.now());
		response.put("status",  HttpStatus.BAD_REQUEST.value());
		response.put("error", "bad request");
		response.put("message", ex.getMessage());
		return new ResponseEntity<Map<String,Object>>(response, HttpStatus.BAD_REQUEST);	
	}
	
	  @ExceptionHandler(SlotNotFoundException.class)
	    public ResponseEntity<Map<String, Object>> handleSlotNotFoundException(SlotNotFoundException ex) {
	        Map<String, Object> errorResponse = new HashMap<>();
	        errorResponse.put("timestamp", LocalDateTime.now());
	        errorResponse.put("status", HttpStatus.NOT_FOUND.value());
	        errorResponse.put("error", "Slot Not Found");
	        errorResponse.put("message", ex.getMessage());

	        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
	    }
	  
	    @ExceptionHandler(Exception.class)
	    public ResponseEntity<Map<String, Object>> handleGenericException(Exception ex) {
	        Map<String, Object> errorResponse = new HashMap<>();
	        errorResponse.put("timestamp", LocalDateTime.now());
	        errorResponse.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
	        errorResponse.put("error", "Internal Server Error");
	        errorResponse.put("message", ex.getMessage());

	        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	    }

}
