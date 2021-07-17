package com.rajkumar.model;

public class CusCategoryDetails {
	private int fid;
	private String category;
	private String goodsName;
	private int qty;
	private double price;
	private int orderQty;
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
	public int getOrderQty() {
		return orderQty;
	}
	public void setOrderQty(int orderQty) {
		this.orderQty = orderQty;
	}
	@Override
	public String toString() {
		return "CusCategoryDetails [fid=" + fid + ", category=" + category + ", goodsName=" + goodsName + ", qty=" + qty
				+ ", price=" + price + ", orderQty=" + orderQty + "]";
	}
	public CusCategoryDetails(int fid, String category, String goodsName, int qty, double price, int orderQty) {
		super();
		this.fid = fid;
		this.category = category;
		this.goodsName = goodsName;
		this.qty = qty;
		this.price = price;
		this.orderQty = orderQty;
	}
	public CusCategoryDetails() {
		super();
	}
	
}
