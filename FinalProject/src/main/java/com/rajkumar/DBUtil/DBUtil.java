package com.rajkumar.DBUtil;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {
	public Connection getConnection() {
		Connection con=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/farmfresh","root" ,"root");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return con;
	}
}
