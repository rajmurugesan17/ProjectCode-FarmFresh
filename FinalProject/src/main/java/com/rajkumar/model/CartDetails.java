package com.rajkumar.model;

public class CartDetails {
	private int fid;
	private String category;
	private String goodsName;
	private int orderQty;
	private double price;
	private double totalPrice;
	public int getFid() {
		return fid;
	}
	public void setFid(int fid) {
		this.fid = fid;
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
	public int getOrderQty() {
		return orderQty;
	}
	public void setOrderQty(int orderQty) {
		this.orderQty = orderQty;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	@Override
	public String toString() {
		return "CartDetails [fid=" + fid + ", category=" + category + ", goodsName=" + goodsName + ", orderQty="
				+ orderQty + ", price=" + price + ", totalPrice=" + totalPrice + "]";
	}
	public CartDetails(int fid, String category, String goodsName, int orderQty, double price, double totalPrice) {
		super();
		this.fid = fid;
		this.category = category;
		this.goodsName = goodsName;
		this.orderQty = orderQty;
		this.price = price;
		this.totalPrice = totalPrice;
	}
	public CartDetails() {
		super();
	}
	
}
