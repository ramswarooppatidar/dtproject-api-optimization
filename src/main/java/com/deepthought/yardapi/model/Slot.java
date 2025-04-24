package com.deepthought.yardapi.model;

import org.springframework.stereotype.Component;

public class Slot {
	/*
	 "yardMap" : [
			{ "x": 1,"y":2, "sizeCap":"small","hasColdUnit":false,"occupied":false },
			{ "x": 2,"y":2, "sizeCap":"big", "hasColdUnit":true, "occupied":false }
		]
	 */
	private int x;
	private int y;
	private String sizeCap;
	private boolean hasColdUnit;
	private boolean occupied;
	
	public Slot(int x, int y, String sizeCap, boolean hasColdUnit, boolean occupied) {
		super();
		this.x = x;
		this.y = y;
		this.sizeCap = sizeCap;
		this.hasColdUnit = hasColdUnit;
		this.occupied = occupied;
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

	public String getSizeCap() {
		return sizeCap;
	}

	public void setSizeCap(String sizeCap) {
		this.sizeCap = sizeCap;
	}

	public boolean isHasColdUnit() {
		return hasColdUnit;
	}

	public void setHasColdUnit(boolean hasColdUnit) {
		this.hasColdUnit = hasColdUnit;
	}

	public boolean isOccupied() {
		return occupied;
	}

	public void setOccupied(boolean occupied) {
		this.occupied = occupied;
	}
	
	
	
}
