package com.rajkumar.model;

public class Details {
	private int id;
	private String name;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Details(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public Details() {
		super();
	}
	@Override
	public String toString() {
		return "Details [id=" + id + ", name=" + name + "]";
	}
	
}
