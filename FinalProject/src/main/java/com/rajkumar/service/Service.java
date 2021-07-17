package com.rajkumar.service;

import java.util.ArrayList;

import com.rajkumar.DAO.DAO;
import com.rajkumar.model.AccountDetails;
import com.rajkumar.model.CartDetails;
import com.rajkumar.model.CategoryDetails;
import com.rajkumar.model.CusCategoryDetails;
import com.rajkumar.model.Details;
import com.rajkumar.model.FarmerOrder;

public class Service {
	DAO d=new DAO();
	public int farmerDetails(AccountDetails ad) {
		int num=d.farmerDetails(ad);
		return num;
	}
	public int farmerLoginCheck(String uName,String pass) {
		return d.fLoginCheckup(uName, pass);
	}
	public Details fDetails() {
		return d.fDetails();
	}
	public ArrayList<String> categoryDetais(){
		ArrayList<String>al=d.getCategory();
		return al;
	}
	
	public void logout() {
		d.logout();
	}
	public int addGoods(CategoryDetails cd,Details de) {
		return d.addGoods(cd, de);
		
	}
	public ArrayList<CategoryDetails> toGetGoods(Details de){
		return d.getGoods(de);
	}
	public void toDeleteGoods(String name) {
		d.deleteGoods(name);
	}
	public ArrayList<FarmerOrder> getFarmerOrder(){
		return d.getFarmerOrders();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	public int customerDetails(AccountDetails ad) {
		return d.customerDetails(ad);
	}
	public int customerLoginCheck(String uName,String pass) {
		return d.cLoginCheckup(uName, pass);
	}
	public Details cDetails() {
		return d.cDetails();
	}
	public ArrayList<CusCategoryDetails> getCusCategoryDetails(String str){
		return d.toGetCusDetails(str);
	}
	public CusCategoryDetails getRequiredGoods(int fid,String name,double price) {
		return d.toGetRequiredGoods(fid, name,price);
	}
	public int getcusorderdetails(CusCategoryDetails ccd,int n) {
		return d.getCusOrderedGoods(ccd,n);
	}
	public ArrayList<CartDetails> getCartDetails(int n){
		return d.getCartDetails(n);
	}
	public void getCusLogout() {
		d.getCusLogout();
	}
	public void toDeleteCartDetails(int fid,String name,int qty,double price) {
		d.toDeleteCartDetails(fid,name,qty,price);
	}
	public double getAmount(int id) {
		return d.getTotalAmount(id);
	}
	public int getPayment(int id) {
		return d.getPayment(id);
	}
	public ArrayList<CartDetails>getCustomerOrderDetails(){
		return d.getCustomerOrderDetails();
	}
	/*
	 * public int contact(int n) { return d.contact(n); }
	 */
}
