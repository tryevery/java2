package com.test11;

import java.sql.Connection;
import java.util.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Driver;

/**
 * 查询goods表中的数据,并将表中的记录倒置输出
 * @author lcj
 *
 */
public class Example11_3{
	public static void main(String[] args) {
		Connection conn;
		PreparedStatement pstm;
		ResultSet rs;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/shop","root","root");
			pstm = conn.prepareStatement("select * from goods ");
			rs = pstm.executeQuery();
			rs.last();
			int rows = rs.getRow();
			System.out.println("goods表共有"+rows+"条记录");
			rs.afterLast();
			System.out.println("倒叙输出表中的数据:");
			while(rs.previous()){
				String id = rs.getString(1);
				String name = rs.getString(2);
				Date date = rs.getDate("madeTime");
				double price = rs.getDouble("price");
				System.out.printf("%-4s",id);
				System.out.printf("%-6s",name);
				System.out.printf("%-15s",date.toString());
				System.out.printf("%6s\n",price);
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
