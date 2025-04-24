package com.deepthought.yardapi.model;

import java.util.List;

import javax.management.loading.PrivateClassLoader;

public class YardRequest {
	/*
	{
		"container" : {
			"id": "c21",
			"size": "small", // "small" or "big"
			"needsCold": false, // true if refrigerated
			 "x": 1, 
			 "y": 1    // crane’s current coords		
			},
		"yardMap" : [
			{ "x": 1,"y":2, "sizeCap":"small","hasColdUnit":false,"occupied":false },
			{ "x": 2,"y":2, "sizeCap":"big", "hasColdUnit":true, "occupied":false }
		]
	 }
	*/
	private Container container;
	private List<Slot> slot;
	
	public YardRequest(Container container, List<Slot> slot) {
		super();
		this.container = container;
		this.slot = slot;
	}
	
	public Container getContainer() {
		return container;
	}
	public void setContainer(Container container) {
		this.container = container;
	}
	public List<Slot> getSlot() {
		return slot;
	}
	public void setSlot(List<Slot> slot) {
		this.slot = slot;
	}
	
}
