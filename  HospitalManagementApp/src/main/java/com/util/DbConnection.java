package com.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection {
static Connection con=null;

 public static Connection createC() {
	try {
		//loading Driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital","root","Rahul@9981");
		
	} catch (Exception e) {
		e.printStackTrace();
		// TODO: handle exception
	}
	 return con;
	 
 }
}
