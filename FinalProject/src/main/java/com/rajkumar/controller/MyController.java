package com.rajkumar.controller;
import java.util.ArrayList;
import java.util.Iterator;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.rajkumar.model.AccountDetails;
import com.rajkumar.model.CartDetails;
import com.rajkumar.model.CategoryDetails;
import com.rajkumar.model.CusCategoryDetails;
import com.rajkumar.model.Details;
import com.rajkumar.model.FarmerOrder;
import com.rajkumar.service.Service;

@Controller
public class MyController {
	Service s=new Service();
	
	@RequestMapping("home")
	public String WelcomePage() {
		return"Home";
	}
	
	@ModelAttribute("categoryDetails")
	public ArrayList<String> cDetails() {
		ArrayList<String>al=s.categoryDetais();
		return al;
	}
	
	@RequestMapping("FarmerNewAccount")
	public String fAccountCreation(Model m) {
		int n=0;
		AccountDetails ad=new AccountDetails();
		m.addAttribute("accDetails", ad);
		m.addAttribute("count",n);
		return"FAccountCreation";
	}
	
	@RequestMapping("FarmerDetails")
	public String farmerDetails(@ModelAttribute("accDetails") AccountDetails ad,Model m) {
		if(ad.getUserName().equals(ad.getPassword())) {
			m.addAttribute("accDetails", ad);
			m.addAttribute("count",-1);
	
			return "FAccountCreation";
			
		}
		else {
		int n=s.farmerDetails(ad);
		if(n==1) {
			
			m.addAttribute("accDetails", ad);
			m.addAttribute("count",n);
	
			return "FAccountCreation";
		}
		else
			return"FarmerSignIn";
		}
		
	}
	
	@RequestMapping("FarmerSignin")
	public String fLogin() {
		return"FarmerSignIn";
	}
	
	@RequestMapping("fLogin")
	public String loginAccess(@RequestParam("uname") String name,@RequestParam("password") String pass ,Model m) {
		int num=s.farmerLoginCheck(name, pass);
		if(num==1) {
			Details d=s.fDetails();
			m.addAttribute("name",d);
			m.addAttribute("id",d.getId());
			return "FarmerCategory";
		}
		else
			return "invalidFLogin";		
	}
	
	@RequestMapping("selectedCategory")
	public String addCategory(@RequestParam("category") String str,Model m) {
			CategoryDetails cd=new CategoryDetails();
			cd.setCategory(str);
			Details d=s.fDetails();
			m.addAttribute("cDetails",cd);
			m.addAttribute("name",d);
			return "GoodsDetails";
		
	}
	
	@RequestMapping("logout")
	public String logout() {
		s.logout();
		return "Home";
	}
	
	@RequestMapping("GoodsDetails")
	public String addGoods(@ModelAttribute("cDetails") CategoryDetails cd,Model m) {
		Details d=s.fDetails();
		int n=s.addGoods(cd, d);
		System.out.println(n);
		if(n==1) {
			m.addAttribute("name",d);
			return"AddgSuccessfull";
		}
		else {
			m.addAttribute("name",d);
			return "AddgUnsuccessfull";
		}
		
	}
	
	@RequestMapping("successfull")
	public String selectCategory(Model m) {
		Details d=s.fDetails();
		m.addAttribute("name",d);
		return "FarmerCategory";
	}
	
	@RequestMapping("unsuccessfull")
	public String selectCategory2(Model m) {
		Details d=s.fDetails();
		m.addAttribute("name",d);
		return "FarmerCategory";
	}
	
	@RequestMapping("goodsdetails")
	public String goodsDetails(Model m) {
		Details d=s.fDetails();
		ArrayList<CategoryDetails>al=s.toGetGoods(d);
		/*
		 * Iterator<CategoryDetails>it=al.iterator(); while(it.hasNext()) {
		 * CategoryDetails cd=it.next(); System.out.println(cd); }
		 */
		if(al.isEmpty()) {
			m.addAttribute("name",d);
			return "DisplayGoods2";
		}
		else {
		m.addAttribute("fullgoodsdetails",al);
		m.addAttribute("name",d);
		return "DisplayGoods";
		}
	}
	
	@RequestMapping("deletegoods")
	public String toDeleteGoods(@RequestParam("pname") String str,Model m) {
		s.toDeleteGoods(str);
		Details d=s.fDetails();
		ArrayList<CategoryDetails>al=s.toGetGoods(d);
		
		if(al.isEmpty()) {
			m.addAttribute("name",d);
			return "DisplayGoods2";
		}
		else {
		m.addAttribute("fullgoodsdetails",al);
		m.addAttribute("name",d);
		return "DisplayGoods";
		}
	}
	
	@RequestMapping("farmerfullorders")
	public String getFarmerFullOrders(Model m) {
		ArrayList<FarmerOrder>al=s.getFarmerOrder();
		Details d=s.fDetails();
		if(al.isEmpty()) {
			m.addAttribute("name",d);
			return "DisplayGoods2";
		}
		else {
			m.addAttribute("farmfulldetails",al);
			m.addAttribute("name",d);
			return "FullListFarmOrders";
		}
	}
	
	
	
	@RequestMapping("CustomerNewAccount")
	public String cNewAccount(Model m) {
		int n=0;
		AccountDetails ad=new AccountDetails();
		m.addAttribute("accDetails", ad);
		m.addAttribute("count",n);
		return "CAccountCreation";
	}
	
	@RequestMapping("CustomerDetails")
	public String customerDetails(@ModelAttribute("accDetails")AccountDetails ad,Model m) {
		if(ad.getUserName().equals(ad.getPassword())) {
			m.addAttribute("accDetails", ad);
			m.addAttribute("count",-1);
	
			return "FAccountCreation";
			
		}
		else {
		int n=s.customerDetails(ad);
		if(n==1) {
			m.addAttribute("accDetails", ad);
			m.addAttribute("count",n);
			return "CAccountCreation";
		}
		else {
		return"CustomerSignIn";
		}
		}
		
	}
	
	@RequestMapping("CustomerSignin")
	public String cLogin() {
		return"CustomerSignIn";
	}
	
	@RequestMapping("cLogin")
	public String loginAccessCustomer(@RequestParam("uname") String name,@RequestParam("password") String pass ,Model m) {
		int num=s.customerLoginCheck(name, pass);
		if(num==1) {
			Details d=s.cDetails();  
			m.addAttribute("name",d);
			return "CustomerCategory";
		}
		else
			return "InvalidcLogin";		
	}
	
	@RequestMapping("selectedCustomerCategory")
	public String selectedcCategory(@RequestParam("category") String str,Model m) {
		ArrayList<CusCategoryDetails>al=s.getCusCategoryDetails(str);
		if(al.isEmpty()) {
			Details d=s.cDetails();
			m.addAttribute("name",d);
			return "EmptyCategory";
		}
		else {
		Details d=s.cDetails();  	 
		m.addAttribute("cuscategorydetails",al);
		m.addAttribute("name",d);
		m.addAttribute("categoryname",str);
		return "CustomerSelectedCategory";
		}
	}
	
	@RequestMapping("customerselectedgoods")
	public String toDisplaySelectedGoods(@RequestParam("fid") int fid,@RequestParam("goodsname") String str,@RequestParam("goodsprice") double price,Model m) {
		CusCategoryDetails ccs=s.getRequiredGoods(fid, str,price);
		//System.out.println(ccs);		
		Details d=s.cDetails(); 
		m.addAttribute("name",d);
		m.addAttribute("requiredgdetails",ccs);
		m.addAttribute("categoryname",ccs.getCategory());
		return "CustomerRequiredGoods";
	}
	
	@RequestMapping("cusordergoods")
	public String cusOrderedGoods(@ModelAttribute("requiredgdetails") CusCategoryDetails ccd,Model m) {
		Details d=s.cDetails(); 
		System.out.println(ccd);
		int flag=s.getcusorderdetails(ccd,d.getId());
		if(flag==1) {
			
			m.addAttribute("name",d);
			return "CartAddedSuccess";
		}
		else {
			ccd.setOrderQty(0);
			m.addAttribute("name",d);
			m.addAttribute("requiredgdetails",ccd);
			m.addAttribute("categoryname",ccd.getCategory());
			return "CartAddedUnsuccess";
		}
	}
	
	@RequestMapping("onemoreorder")
	public String addOneMoreOrder(Model m) {
		Details d=s.cDetails();  
		m.addAttribute("name",d);
		return "CustomerCategory";
	}
	
	@RequestMapping("displaycuscartdetails")
	public String getCartDetails(Model m) {
		Details d=s.cDetails();  
		ArrayList<CartDetails>al=s.getCartDetails(d.getId());
		if(al.isEmpty()) {
			
			m.addAttribute("name",d);
			return "DisplayEmptyCart";
		}
		else {
			
			m.addAttribute("name",d);
			m.addAttribute("cartdetails",al);
			return "DisplayCart";
		}
	}
	
	@RequestMapping("logoutcustomer")
	public String getCusLogout() {
		s.getCusLogout();
		return "Home";
	}
	
	@RequestMapping("deletecartdetails")
	public String deleteCDetail(@RequestParam("fid") int fid,@RequestParam("gname") String name,@RequestParam("qty") int qty,@RequestParam("price") double price,Model m) {
		s.toDeleteCartDetails(fid,name,qty,price);
		Details d=s.cDetails(); 
		ArrayList<CartDetails>al=s.getCartDetails(d.getId());
		if(al.isEmpty()) {
			 
			m.addAttribute("name",d);
			return "DisplayEmptyCart";
		}
		else {
			  
			m.addAttribute("name",d);
			m.addAttribute("cartdetails",al);
			return "DisplayCart";
		}
		
	}
	
	@RequestMapping("checkout")
	public String displayAmount(Model m) {
		Details d=s.cDetails(); 
		double amt=s.getAmount(d.getId());
		m.addAttribute("totalamount",amt);
		m.addAttribute("name",d);
		return "FinalPage";
		
	}
	
	@RequestMapping("payment")
	public String getPayment(Model m) {
		Details d=s.cDetails(); 
		s.getPayment(d.getId());
		m.addAttribute("name",d);
		return "FinalProcessPage";
	}
	
	@RequestMapping("myorderscus")
	public String displayCustomerOrders(Model m) {
		ArrayList<CartDetails>al=s.getCustomerOrderDetails();
		Details d=s.cDetails(); 
		if(al.isEmpty()) {
			 
			m.addAttribute("name",d);
			return "DisplayEmptyCart";
		}
		else {
		m.addAttribute("name",d);
		m.addAttribute("yourorderdetails",al);
		return "FullListCusOrders";
		}
	}
	
	@RequestMapping("aboutusf")
	public String toReturnf() {
		
		return "AboutUsf";
		
	}
	
	@RequestMapping("contactusf")
	public String toContactf(Model m) {
			return "ContactUsf";
	}
	
}
