package com.rajkumar.model;

public class FarmerOrder {
	private String name;
	private String number;
	private String location;
	private String category;
	private String goodsName;
	private int qty;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	@Override
	public String toString() {
		return "FarmerOrder [name=" + name + ", number=" + number + ", location=" + location + ", category=" + category
				+ ", goodsName=" + goodsName + ", qty=" + qty + "]";
	}
	public FarmerOrder(String name, String number, String location, String category, String goodsName, int qty) {
		super();
		this.name = name;
		this.number = number;
		this.location = location;
		this.category = category;
		this.goodsName = goodsName;
		this.qty = qty;
	}
	public FarmerOrder() {
		super();
	}
	
	
}
