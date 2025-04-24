package com.deepthought.yardapi.model;

public class Container {
	/*
	
		"container" : {
			"id": "c21",
			"size": "small", // "small" or "big"
			"needsCold": false, // true if refrigerated
			 "x": 1, 
			 "y": 1    // crane’s current coords		
			},
		
	*/
	private String id;
	private String size;
	private boolean needsCold;
	private int x;
	private int y;
	public Container(String id, String size, boolean needsCold, int x, int y) {
		super();
		this.id = id;
		this.size = size;
		this.needsCold = needsCold;
		this.x = x;
		this.y = y;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public boolean isNeedsCold() {
		return needsCold;
	}
	public void setNeedsCold(boolean needsCold) {
		this.needsCold = needsCold;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	
	
}
