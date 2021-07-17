package com.rajkumar.model;

public class CategoryDetails {
	private String category;
	private String goodsName;
	private int qty;
	private double price;
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
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "CategoryDetails [category=" + category + ", goodsName=" + goodsName + ", qty=" + qty + ", price="
				+ price + "]";
	}
	public CategoryDetails(String category, String goodsName, int qty, double price) {
		super();
		this.category = category;
		this.goodsName = goodsName;
		this.qty = qty;
		this.price = price;
	}
	public CategoryDetails() {
		super();
	}
	
}
