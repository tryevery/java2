package com.test11;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

interface DB{
	Connection getConnection();
}
public class DBConnection implements DB{

	@Override
	public Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/shop","root","root");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return conn;
	}
	
}
