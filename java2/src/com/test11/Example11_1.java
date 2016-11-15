package com.test11;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 查询goods表中price字段大于3000的全部记录
 * @author lcj
 *
 */
public class Example11_1 {
	public static void main(String[] args) {
		Connection conn = null;
		Statement stm = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/shop", "root", "root");
			stm = conn.createStatement();
			String sql = "select * from goods where price > 299900";
			rs = stm.executeQuery(sql);
			while(rs.next()){
				System.out.println(rs.getString("id")
								  +"\t"
								  +rs.getString("name")
								  +"\t"
								  +rs.getString("madeTime")
								  +"\t"
								  +rs.getString("price"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			try {
				conn.close();
				stm.close();
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
	}
}
