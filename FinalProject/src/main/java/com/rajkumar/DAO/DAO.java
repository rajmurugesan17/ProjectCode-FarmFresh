package com.rajkumar.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.rajkumar.DBUtil.DBUtil;
import com.rajkumar.model.AccountDetails;
import com.rajkumar.model.CartDetails;
import com.rajkumar.model.CategoryDetails;
import com.rajkumar.model.CusCategoryDetails;
import com.rajkumar.model.Details;
import com.rajkumar.model.FarmerOrder;

public class DAO {
	DBUtil db=new DBUtil();
	Connection con=db.getConnection();
	public int farmerDetails(AccountDetails ad) {             //farmer account creation
		int flag=0;
		try {
			PreparedStatement ps1=con.prepareStatement("select username from farmerlogin where username=?");	//to check username is already exists
			ps1.setString(1,ad.getUserName());
			ResultSet rs=ps1.executeQuery();
			while(rs.next()) {
				flag=1;
			}
			if(flag==0) {
			PreparedStatement ps=con.prepareStatement("insert into farmerlogin(name,phoneno,location,username,password) values(?,?,?,?,?)");
			ps.setString(1,ad.getName());
			ps.setString(2,ad.getPhoneNumber());
			ps.setString(3,ad.getLocation());
			ps.setString(4,ad.getUserName());
			ps.setString(5,ad.getPassword());
			ps.executeUpdate();
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	public int fLoginCheckup(String uName,String pass) {			//farmer login check
		int flag=0,id=0;
		String name = null;
		try {
			PreparedStatement ps=con.prepareStatement("select * from farmerlogin where username=? and password=?");
			ps.setString(1,uName);
			ps.setString(2,pass);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				flag=1;
				 id=rs.getInt(1);
				 name=rs.getString(2);
			}
			if(flag==1) {
				
				try {
					PreparedStatement ps1=con.prepareStatement("insert into login(id,name) values(?,?)");
					ps1.setInt(1,id);
					ps1.setString(2,name);
					ps1.executeUpdate();
				}
				catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	public Details fDetails() {				//to retrieve the current farmer login
		Details d=new Details();
		try {
			PreparedStatement ps=con.prepareStatement("select * from login ");
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				d.setId(rs.getInt(1));
				d.setName(rs.getString(2));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return d;		
	}
	public ArrayList<String> getCategory(){				//get the full category from the database
		ArrayList<String>al=new ArrayList<String>();
		try {
			PreparedStatement ps=con.prepareStatement("select * from category");
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				al.add(rs.getString(1));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return al;
	}
	
	public void logout() {			//logout farmer
		try {
			PreparedStatement ps=con.prepareStatement("delete from login");
			ps.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	public int addGoods(CategoryDetails cd,Details d) {				//adding goods in the desired category by farmer
		int flag=0,temp=0;
		try {
			PreparedStatement ps1=con.prepareStatement("select * from goods where fid=? and gname=? and price=?");
			ps1.setInt(1,d.getId());
			ps1.setString(2,cd.getGoodsName());
			ps1.setDouble(3,cd.getPrice());
			ResultSet rs=ps1.executeQuery();
			while(rs.next()) {
				PreparedStatement ps2=con.prepareStatement("update goods set qty=? where fid=? and gname=? and price=?");
				int q=rs.getInt(4);
				ps2.setInt(1,(q+cd.getQty()));
				ps2.setInt(2,d.getId());
				ps2.setString(3,cd.getGoodsName());
				ps2.setDouble(4,cd.getPrice());
				ps2.executeUpdate();
				temp=1;
				flag=1;
			}
			if(temp==0) {
			PreparedStatement ps=con.prepareStatement("insert into goods values(?,?,?,?,?)");
			ps.setInt(1,d.getId());
			ps.setString(2,cd.getCategory());
			ps.setString(3,cd.getGoodsName());
			ps.setInt(4,cd.getQty());
			ps.setDouble(5,cd.getPrice());
			ps.executeUpdate();
			flag=1;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	public ArrayList<CategoryDetails> getGoods(Details d){					//get the farmer goods details
		ArrayList<CategoryDetails>al=new ArrayList<CategoryDetails>();
		
		try {
			PreparedStatement ps=con.prepareStatement("select * from goods where fid=?");
			ps.setInt(1,d.getId());
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				if(rs.getInt(4)>0) {
				CategoryDetails cd=new CategoryDetails();
				cd.setCategory(rs.getString(2));
				cd.setGoodsName(rs.getString(3));
				cd.setQty(rs.getInt(4));
				cd.setPrice(rs.getDouble(5));
				al.add(cd);
				}else
					continue;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return al;
	}
	public void deleteGoods(String name) {				//delete the particular goods from the farmer goods details
		try {
			PreparedStatement ps=con.prepareStatement("delete from goods where gname=?");
			ps.setString(1,name);
			ps.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	public ArrayList<FarmerOrder> getFarmerOrders(){			//get the ordered details of the customers
		ArrayList<FarmerOrder>al=new ArrayList<FarmerOrder>();
		Details d=fDetails();
		int id=d.getId();
		try {
			PreparedStatement ps=con.prepareStatement("select * from farmerordertable where fid=?");
			ps.setInt(1,id);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				FarmerOrder fo=new FarmerOrder();
				fo.setName(rs.getString(2));
				fo.setNumber(rs.getString(3));
				fo.setLocation(rs.getString(4));
				fo.setCategory(rs.getString(5));
				fo.setGoodsName(rs.getString(6));
				fo.setQty(rs.getInt(7));
				al.add(fo);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return al;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public int customerDetails(AccountDetails ad) {							//customer account creation
		int flag=0;
		try {
			PreparedStatement ps1=con.prepareStatement("select username from customerlogin where username=?");
			ps1.setString(1,ad.getUserName());
			ResultSet rs=ps1.executeQuery();
			while(rs.next()) {
				flag=1;
			}
			if(flag==0) {
			PreparedStatement ps=con.prepareStatement("insert into customerlogin(name,phoneno,location,username,password) values(?,?,?,?,?)");
			ps.setString(1,ad.getName());
			ps.setString(2,ad.getPhoneNumber());
			ps.setString(3,ad.getLocation());
			ps.setString(4,ad.getUserName());
			ps.setString(5,ad.getPassword());
			ps.executeUpdate();
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return flag;		
	}
	public int cLoginCheckup(String uName,String pass) {				//customer login checkup
		int flag=0,id=0;
		String name = null;
		try {
			PreparedStatement ps=con.prepareStatement("select * from customerlogin where username=? and password=?");
			ps.setString(1,uName);
			ps.setString(2,pass);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				flag=1;
				 id=rs.getInt(1);
				 name=rs.getString(2);
			}
			if(flag==1) {
				
				try {
					PreparedStatement ps1=con.prepareStatement("insert into clogin(id,name) values(?,?)");
					ps1.setInt(1,id);
					ps1.setString(2,name);
					ps1.executeUpdate();
				}
				catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	public Details cDetails() {				//get the current customer login details
		Details d=new Details();
		try {
			PreparedStatement ps=con.prepareStatement("select * from clogin ");
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				d.setId(rs.getInt(1));
				d.setName(rs.getString(2));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return d;		
	}
	public ArrayList<CusCategoryDetails>toGetCusDetails(String str){			//get the customer selected category
		ArrayList<CusCategoryDetails>al=new ArrayList<CusCategoryDetails>();
		try {
			PreparedStatement ps=con.prepareStatement("select * from goods where category=?");
			ps.setString(1,str);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				if(rs.getInt(4)>0) {
				CusCategoryDetails ccd=new CusCategoryDetails();
				ccd.setFid(rs.getInt(1));
				ccd.setCategory(rs.getString(2));
				ccd.setGoodsName(rs.getString(3));
				ccd.setQty(rs.getInt(4));
				ccd.setPrice(rs.getDouble(5));
				al.add(ccd);
				}
				else
					continue;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return al;
	}
	public CusCategoryDetails toGetRequiredGoods(int fid,String name,double price) {		//get the customer selected goods list
		CusCategoryDetails ccs=new CusCategoryDetails();
		try {
			PreparedStatement ps=con.prepareStatement("select * from goods where fid=? and gname=? and price=?");
			ps.setInt(1,fid);
			ps.setString(2,name);
			ps.setDouble(3,price);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				ccs.setFid(rs.getInt(1));
				ccs.setCategory(rs.getString(2));
				ccs.setGoodsName(rs.getString(3));
				ccs.setQty(rs.getInt(4));
				ccs.setPrice(rs.getDouble(5));
			}
			try {
				PreparedStatement ps1=con.prepareStatement("insert into cusfid values(?)");		//getting goods id
				ps1.setInt(1,ccs.getFid());
				ps1.executeUpdate();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return ccs;
	}
	public int getCusOrderedGoods(CusCategoryDetails ccd,int n) {			//insert goods into customercart
		int fid=0,flag=0, temp=0,orderqty=0;
		double price=0,cprice=0;
		try {
			PreparedStatement ps=con.prepareStatement("select * from cusfid");
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				fid=rs.getInt(1);
			}
			System.out.println(fid);
			PreparedStatement ps1=con.prepareStatement("select * from goods where fid=? and gname=? and price=?");
			ps1.setInt(1,fid);
			ps1.setString(2,ccd.getGoodsName());
			
			ps1.setDouble(3,ccd.getPrice());
			
			ResultSet rs1=ps1.executeQuery();
			//System.out.println(rs1.getInt(4));
			while(rs1.next()) {	
				if(ccd.getOrderQty()<=rs1.getInt(4)) {
					PreparedStatement ps5=con.prepareStatement("select * from customercart where cid=? and fid=? and goodsname=? and price=?");
					ps5.setInt(1,n);
					ps5.setInt(2,fid);
					ps5.setString(3,ccd.getGoodsName());
					ps5.setDouble(4,ccd.getPrice());
					ResultSet rs5=ps5.executeQuery();
					while(rs5.next()) {
						
						orderqty=rs5.getInt(5);
						
						cprice=rs5.getDouble(7);
						
						temp=1;
					}
					if(temp==1) {
						PreparedStatement ps6=con.prepareStatement("delete from customercart where  cid=? and fid=? and goodsname=? and price=?");
						ps6.setInt(1,n);
						ps6.setInt(2,fid);
						ps6.setString(3,ccd.getGoodsName());
						ps6.setDouble(4,ccd.getPrice());
						ps6.executeUpdate();
						/*
						 * ps6.setInt(1,(ccd.getOrderQty()+orderqty));
						 * System.out.println(ccd.getOrderQty()+orderqty);
						 * price=ccd.getOrderQty()*ccd.getPrice(); System.out.println(price);
						 * System.out.println(price+cprice); ps6.setDouble(2,(price+cprice));
						 * ps6.setInt(3,n); ps6.setInt(4,fid); ps6.setString(5,ccd.getGoodsName());
						 * ps6.setDouble(6,ccd.getPrice());
						 */
						
						//flag=1;
						PreparedStatement ps7=con.prepareStatement("insert into customercart values(?,?,?,?,?,?,?)");
						//System.out.println(n);
						ps7.setInt(1,n);
						ps7.setInt(2,fid);
						ps7.setString(3,ccd.getCategory());
						ps7.setString(4,ccd.getGoodsName());
						ps7.setInt(5,(ccd.getOrderQty()+orderqty));
						ps7.setDouble(6,ccd.getPrice());
						price=ccd.getOrderQty()*ccd.getPrice();
						ps7.setDouble(7,(price+cprice));
						ps7.executeUpdate();
						flag=1;
					}
					else {
					PreparedStatement ps2=con.prepareStatement("insert into customercart values(?,?,?,?,?,?,?)");
					
					ps2.setInt(1,n);
					ps2.setInt(2,fid);
					ps2.setString(3,ccd.getCategory());
					ps2.setString(4,ccd.getGoodsName());
					ps2.setInt(5,ccd.getOrderQty());
					ps2.setDouble(6,ccd.getPrice());
					price=ccd.getOrderQty()*ccd.getPrice();
					ps2.setDouble(7,price);
					ps2.executeUpdate();
					flag=1;
					}
					PreparedStatement ps3=con.prepareStatement("update goods set qty=? where fid=? and gname=? and price=?");
					ps3.setInt(1,rs1.getInt(4)-ccd.getOrderQty());
					ps3.setInt(2,fid);
					ps3.setString(3,ccd.getGoodsName());
					ps3.setDouble(4,ccd.getPrice());
					ps3.executeUpdate();
					PreparedStatement ps4=con.prepareStatement("delete from cusfid where fid=?");
					ps4.setInt(1,fid);
					ps4.executeUpdate();
				}
				else
					flag=-1;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	public ArrayList<CartDetails>getCartDetails(int n){				//get cart details of the customer
		ArrayList<CartDetails>al=new ArrayList<CartDetails>();
		try {
			PreparedStatement ps=con.prepareStatement("select * from customercart where cid=?");
			ps.setInt(1,n);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				CartDetails cd=new CartDetails();
				cd.setFid(rs.getInt(2));
				cd.setCategory(rs.getString(3));
				cd.setGoodsName(rs.getString(4));
				cd.setOrderQty(rs.getInt(5));
				cd.setPrice(rs.getDouble(6));
				cd.setTotalPrice(rs.getDouble(7));
				al.add(cd);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return al;
	}
	public void getCusLogout() {		//delete login of the customer
		try {
			PreparedStatement ps=con.prepareStatement("delete from clogin");
			ps.executeUpdate();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void toDeleteCartDetails(int fid,String name,int qty,double price) {		//to delete the goods in the cart
		int gqty=0;
		try {
			PreparedStatement ps=con.prepareStatement("select qty from goods  where fid=? and gname=? and price=?");
			ps.setInt(1,fid);
			ps.setString(2,name);
			ps.setDouble(3,price);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				gqty=rs.getInt(1);
			}
			PreparedStatement ps1=con.prepareStatement("update goods set qty=? where fid=? and gname=? and price=?");
			ps1.setInt(1,gqty+qty);
			ps1.setInt(2,fid);
			ps1.setString(3,name);
			ps1.setDouble(4,price);
			ps1.executeUpdate();
			PreparedStatement ps2=con.prepareStatement("delete from customercart  where fid=? and goodsname=? and price=?");
			ps2.setInt(1,fid);
			ps2.setString(2,name);
			ps2.setDouble(3,price);
			ps2.executeUpdate();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	public double getTotalAmount(int id) {		//calculating total price
		double amt=0;
		try {
			PreparedStatement ps=con.prepareStatement("select totalprice from customercart where cid=?");
			ps.setInt(1,id);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				amt=amt+rs.getDouble(1);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return amt;
	}
	public int getPayment(int id) {
		int flag=0;
		try {
			PreparedStatement ps=con.prepareStatement("select * from customercart where cid=?");
			ps.setInt(1,id);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				PreparedStatement ps1=con.prepareStatement("insert into customerorderdetails values(?,?,?,?,?,?,?)");
				ps1.setInt(1,rs.getInt(1));
				ps1.setInt(2,rs.getInt(2));
				ps1.setString(3,rs.getString(3));
				ps1.setString(4,rs.getString(4));
				ps1.setInt(5,rs.getInt(5));
				ps1.setDouble(6,rs.getDouble(6));
				ps1.setDouble(7,rs.getDouble(7));
				ps1.executeUpdate();
				PreparedStatement ps2=con.prepareStatement("select * from customerlogin where id=?");
				ps2.setInt(1,id);
				ResultSet rs1=ps2.executeQuery();
				while(rs1.next()) {
					PreparedStatement ps4=con.prepareStatement("insert into farmerordertable values(?,?,?,?,?,?,?)");
					ps4.setInt(1,rs.getInt(2));
					ps4.setString(2,rs1.getString(2));
					ps4.setString(3,rs1.getString(3));
					ps4.setString(4,rs1.getString(4));
					ps4.setString(5,rs.getString(3));
					ps4.setString(6,rs.getString(4));
					ps4.setInt(7,rs.getInt(5));
					ps4.executeUpdate();
				}
				PreparedStatement ps3=con.prepareStatement("delete from customercart where cid=?");
				ps3.setInt(1,id);
				ps3.executeUpdate();
				flag=1;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	public ArrayList<CartDetails>getCustomerOrderDetails(){
		ArrayList<CartDetails>al=new ArrayList<CartDetails>();
		Details d=cDetails();
		int cid=d.getId();
		try {
			PreparedStatement ps=con.prepareStatement("select * from customerorderdetails where cid=?");
			ps.setInt(1,cid);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				CartDetails cd=new CartDetails();
				cd.setFid(rs.getInt(2));
				cd.setCategory(rs.getString(3));
				cd.setGoodsName(rs.getString(4));
				cd.setOrderQty(rs.getInt(5));
				cd.setPrice(rs.getDouble(6));
				cd.setTotalPrice(rs.getDouble(7));
				al.add(cd);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return al;
	}
	/*
	 * public int contact(int n) { int flag=0; if(n==0) { try { PreparedStatement
	 * ps=con.prepareStatement("select * from login "); ResultSet
	 * rs=ps.executeQuery(); while(rs.next()) { flag=1; } } catch(Exception e) {
	 * e.printStackTrace(); } return flag; } else { try { PreparedStatement
	 * ps=con.prepareStatement("select * from clogin "); ResultSet
	 * rs=ps.executeQuery(); while(rs.next()) { flag=1; } } catch(Exception e) {
	 * e.printStackTrace(); } return flag; }
	 * 
	 * }
	 */
}
