package com.deepthought.yardapi.controller;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.deepthought.yardapi.model.YardRequest;
import com.deepthought.yardapi.service.YardService;

@RestController
public class YardController {
	
	private YardService yardService;
	
	public YardController(YardService yardService) {
		this.yardService = yardService;
	}

	@PostMapping("/pickSlot")
	public ResponseEntity<Map<String, Object>> pickSpot(@RequestBody YardRequest yardRequest){
		Map<String, Object> resultMap = yardService.findBestSpot(yardRequest);
		return new ResponseEntity<Map<String, Object>>(resultMap, HttpStatus.OK);
	}
}
